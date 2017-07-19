package week1.strings;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * Example:
 *
 * a = "100"
 *
 * b = "11"
 * Return a + b = “111”.
 *
 * Created by Elmira Andreeva on 7/17/17.
 */
public class AddBinaryStrings {

    public String addBinary(String a, String b) {
        int N = a.length();
        int M = b.length();
        int carry = 0;

        int i = N - 1, j = M - 1;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int value = carry;
            if (i >= 0) {
                value += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                value += b.charAt(j) - '0';
                j--;
            }
            sb.append(value % 2);
            carry = value / 2;

        }
        if (carry > 0) sb.append(carry % 2);

        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "1010110111001101101000";
        String b = "1000011011000000111100110";

        System.out.println(a);
        System.out.println(b);
        System.out.println("sum:");
        System.out.println(new AddBinaryStrings().addBinary(a, b));
    }
}
