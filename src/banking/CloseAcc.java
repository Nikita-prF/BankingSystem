package banking;
import java.sql.*;

/**
 * Class of account removal
 */
public class CloseAcc {

    /**
     * Erases all user's data from the database
     * @param idLog unique user ID
     */
    public static void close(int idLog) {

        String sql = String.format("DELETE FROM card WHERE id = %d;", idLog);


        try (Connection conn = CreateDb.connect();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("\nThe account has been closed!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
