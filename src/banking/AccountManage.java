package banking;
import java.util.Scanner;

/**
 * Account Management Class
 *
 * @author Nikita Filimonov
 */
public class AccountManage {
    GetData base = new GetData();
    Scanner scan = new Scanner(System.in);

    /**
     * Run a set of database interactions in accordance with user commands
     * @param idLog unique user ID
     */
    public void mangeAccount(int idLog) {

        label:
        while (true) {
            System.out.println();
            System.out.println("1. Balance");
            System.out.println("2. Add income");
            System.out.println("3. Do transfer");
            System.out.println("4. Close account");
            System.out.println("0. Exit");
            switch (scan.nextInt()) {
                case 1:
                    System.out.printf("\nBalance: %d\n",base.getBalance(idLog));
                    break;
                case 2:
                    AddIncome.addCash(idLog);
                    break;
                case 3:
                    Transfer.trans(idLog);
                    break;
                case 4:
                    CloseAcc.close(idLog);
                    break label;
                case 5:
                    System.out.println("\nYou have successfully logged out!");
                    break label;
                case 0:
                    System.out.println("\nBye!\n");
                    System.exit(1);
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}
