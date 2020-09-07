package banking;
import java.sql.*;
import java.util.Scanner;

/**
 * Account access class
 *
 * @author Nikita Filimonov
 */
public class Login {
    Scanner scan = new Scanner(System.in);

    /**
     * Checking the data entered by the user.
     * @return unique user ID
     */
    public int isLogin() {
        System.out.println("Enter your card number:");
        String cardN = scan.nextLine();

        System.out.println("Enter your PIN:");
        String pinCode = scan.nextLine();
        int idLog = 0;

        String sql = String.format("SELECT id, number, pin FROM card WHERE number = '%s';", cardN);

        try (Connection conn = CreateDb.connect();
             Statement statement = conn.createStatement()) {
                ResultSet card = statement.executeQuery(sql);
                int i = card.getInt("id");
                if (i != 0 && card.getString("pin").equals(pinCode)) {
                    idLog = i;
                    System.out.println("\nYou have successfully logged in!");
                }
        } catch (SQLException ignored) {}
        return idLog;
    }
}
