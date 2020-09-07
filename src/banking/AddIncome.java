package banking;
import java.sql.*;
import java.util.Scanner;


/**
 * Cash deposit class
 *
 * @author Nikita Filimonov
 */
public class AddIncome {

    /**
     * Deposits cash to the card of a certain user by user ID
     * @param idLog unique user ID
     */
    public static void addCash(int idLog) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter income:");
        int cash = scan.nextInt();

        String sql = String.format("UPDATE card SET balance = balance + %d WHERE id = %d;", cash, idLog);
        try (Connection conn = CreateDb.connect();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("\nIncome was added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
