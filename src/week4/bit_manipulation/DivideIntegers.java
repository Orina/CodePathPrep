package week4.bit_manipulation;

/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * Return the floor of the result of the division.
 *
 * Example:
 *
 * 5 / 2 = 2
 * Also, consider if there can be overflow cases. For overflow case, return INT_MAX.
 *
 * Created by Elmira Andreeva on 8/2/17.
 */
public class DivideIntegers {

    public int divide(int a, int b) {
        long x = a;
        long y = b;
        boolean sign = (x < 0 && y > 0) || (x > 0 && y < 0);

        if (x < 0) x = -x;
        if (y < 0) y = -y;

        if (y == 1) {
            x = sign ? -x : x;
            return (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int) x;
        }

        long result = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }

            result += 1L << power;
            x -= yPower;
        }
        return
                sign ? -((int) result) : (result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result);
    }
}
