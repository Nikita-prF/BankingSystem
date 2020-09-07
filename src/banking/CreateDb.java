package banking;
import java.io.File;
import java.sql.*;


/**
 * A class that creates a database at a location defined by the user.
 *
 * @author Nikita Filimonov
 */
public class CreateDb {

    public static String pathToDb = "";


    /**
     * The method creates a database if it does not already exist
     * and establishes a connection to it based on the string with the URL received from the user.
     * @param fileName URL-path to database
     */
    public void createNewDataBase(String fileName) {
        try {
             File dbFile = new File(fileName);
             pathToDb = dbFile.getAbsolutePath();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        String url = String.format("jdbc:sqlite:%s",pathToDb);

        String sql = "CREATE TABLE IF NOT EXISTS card (\n"
                + "         id INTEGER PRIMARY KEY NOT NULL ,\n"
                + "         number TEXT,\n"
                + "         pin TEXT, \n"
                + "         balance INTEGER DEFAULT 0\n"
                + ");";


        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                conn.getMetaData();
            }
            Statement statement = conn.createStatement();
            statement.execute(sql);
    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Create a new connection with database
     * @return new Connection object
     */
    public static Connection connect() {

        String url = String.format("jdbc:sqlite:%s", pathToDb);

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
