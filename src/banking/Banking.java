package banking;
import java.util.Scanner;

/**
 * The program implementing a simple banking system of creating and managing unique user credit cards
 * Allowed manage function:
 *
 *  1. Creating card
 *  2. Login to personal account.
 *  3. Adding cash.
 *  4. Transferring of cash to another credit card
 *  5. Deleting card from system
 *
 *  The program uses the local sqlite database to store user data.
 *
 * @author Nikita Filimonov
 */
public class Banking {
    Login acc = new Login();
    AccountManage accountManage = new AccountManage();

    /**
     * A method that calls the process of creating a new card
     * and shows the information about this card.
     */
    void CreateAccount() {
        Account newAcc = new Account();
        newAcc.newAccount();
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(newAcc.getCardNumber());
        System.out.println("Your card PIN:");
        System.out.println(newAcc.getPinCode());
    }

    /**
     * Process of handling user commands
     * @param cmd Number of command value
     */
    void Action(int cmd) {
        System.out.println();
        switch (cmd) {
                case 1:
                    CreateAccount();
                    break;
                case 2:
                    int idLog = acc.isLogin();
                    if (idLog != 0) {
                        accountManage.mangeAccount(idLog);
                    } else {
                        System.out.println("\nWrong card number or PIN!");
                    }
                    break;
                case 0:
                    System.out.println("Bye!\n");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Banking bank = new Banking();
        CreateDb dataBase = new CreateDb();

        /* Checking for correctness of program arguments received from the user */
        if (args.length == 2 && args[0].equals("-fileName") ||
                args.length == 4 && args[2].equals("-fileName")) {
            dataBase.createNewDataBase(args[1]);
            while (true) {
                System.out.println("1. Create an account");
                System.out.println("2. Log into account");
                System.out.println("0. Exit");
                bank.Action(scan.nextInt());
                System.out.println();
            }
        }
    }
}
