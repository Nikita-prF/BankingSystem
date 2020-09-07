package banking;

/**
 * Class of algorithm implementation
 *
 * @author Nikita Filimonov
 */
public class LuhnValid {

    /**
     * A method that checks the card number by a special "Luhn" algorithm
     * @param cardNum card number
     * @return boolean value as result of checking
     */
    public static boolean isValid(String cardNum) {
        String[] str = cardNum.split("");
        int[] num = new int[str.length];
        int sum = 0;
        for (int i = 0; i < str.length - 1; i++) {
            if (i % 2 != 0) {
                num[i] = Integer.parseInt(str[i]) * 2;
            } else {
                num[i] = Integer.parseInt(str[i]);
            }
            if (num[i] >= 10) {num[i] -= 9;}
            sum += num[i];
        }
        return  Integer.parseInt(str[str.length - 1]) + sum % 10 == 0;
    }
}
