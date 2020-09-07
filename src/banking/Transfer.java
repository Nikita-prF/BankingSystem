package banking;
import java.sql.*;
import java.util.Scanner;

/**
 * Class enabling cash transfers
 */
public class Transfer {

    /**
     *  Method of cash transfer with three validation checks
     * @param idLog unique user ID
     */
    public static void trans(int idLog) {
        Scanner scan = new Scanner(System.in);
        GetData base = new GetData();

        System.out.println("\nTransfer");
        System.out.println("Enter card number:");
        String cardNum = scan.nextLine();

        /* 1. Checking card number by "Luhn" algorithm */
        if (LuhnValid.isValid(cardNum)) {

            try (Connection conn = CreateDb.connect();
                 Statement statement = conn.createStatement()) {

                ResultSet card = statement.executeQuery("SELECT * FROM card WHERE number = " + cardNum + ";");

                /* 2. Checking for existence of this card in the database */
                if (card.getInt("id") != 0) {
                    System.out.println("\nEnter how much money you want to transfer:");
                    int cash = Integer.parseInt(scan.nextLine());

                    /* 3. Checking for enough money to make a transfer. */
                    if (base.getBalance(idLog) >= cash) {


                        statement.executeUpdate("UPDATE FROM card " +
                                                    "SET balance = balance - " + cash +
                                                    " WHERE id = " + idLog +";");

                        statement.executeUpdate("UPDATE FROM card " +
                                                    " SET balance = balance + " + cash +
                                                    " WHERE number = " + cardNum +";");

                        System.out.println("\nSuccess!");
                    } else {
                        System.out.println("\nNot enough money!");
                    }
                } else {
                    System.out.println("\nSuch a card does not exist.");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("\nProbably you made mistake in the card number. Please try again!");
        }
    }


}
