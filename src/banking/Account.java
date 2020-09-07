package banking;
import java.util.Random;
import java.sql.*;


/**
 * Account class is responsible for generating a temporary account to add it to DB in the future.
 *
 * @author Nikita Filimonov
 */
public class Account {
    Random rand;

    private String cardNumber = "400000";
    private String pinCode = "";

    /**
     * A method that generates data according to the "Luhn" algorithm
     * and add a new object to the DB.
     */
    public void newAccount() {
        rand = new Random();

        int sum = 8;
        int id = 0;
        int[] cardNumInt = new int[9];

        for (int i = 0; i < 9; i++) {
            int num = rand.nextInt(10);
            if (i % 2 == 0) {
                cardNumInt[i] = num * 2;
            } else {
                cardNumInt[i] = num;
            }
            this.cardNumber += Integer.toString(num);
        }

        for (int i = 0; i < cardNumInt.length; i++) {
            if (cardNumInt[i] >= 10) {
                cardNumInt[i] -= 9;
            }
            sum += cardNumInt[i];
        }
        while ((id + sum) % 10 != 0) {
            id++;
        }
        this.cardNumber += Integer.toString(id);

        for (int i = 0; i < 4; i++) {
            this.pinCode += Integer.toString(rand.nextInt(10));
        }


        String sql = String.format("INSERT INTO card(number, pin) VALUES('%s','%s');", cardNumber, pinCode);

        try {
             Connection conn = CreateDb.connect();
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

}
