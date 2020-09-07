package banking;
import java.sql.*;

/**
 * Class of obtaining specific data from the database
 *
 * @author Nikita Filimonov
 */
public class GetData {

    /**
     * A method that receives the quantity of money of a certain user
     * @param idLog unique user ID
     * @return total Cash amount
     */
    public int getBalance(int idLog) {
        String sql = String.format("SELECT balance FROM card WHERE id = %d;", idLog);
        int balance = 0;

        try (Connection conn = CreateDb.connect();
             Statement statement = conn.createStatement()) {
            ResultSet card = statement.executeQuery(sql);
            balance = card.getInt("balance");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return balance;
    }
}
