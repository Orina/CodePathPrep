package week1.strings;

import java.util.Stack;

/**
 * Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

 Input is guaranteed to be within the range from 1 to 3999.

 Example :

 Input : 5
 Return : "V"

 Input : 14
 Return : "XIV"

 * Created by Elmira Andreeva on 7/12/17.
 */
public class IntegerToRoman {

    public String intToRoman(int a) {

        StringBuilder sb = new StringBuilder();

        Stack<RomanInteger> stack = new Stack();
        stack.push(new RomanInteger(1, "I"));
        stack.push(new RomanInteger(4, "IV"));
        stack.push(new RomanInteger(5, "V"));
        stack.push(new RomanInteger(9, "IX"));
        stack.push(new RomanInteger(10, "X"));
        stack.push(new RomanInteger(40, "XL"));
        stack.push(new RomanInteger(50, "L"));
        stack.push(new RomanInteger(90, "XC"));
        stack.push(new RomanInteger(100, "C"));
        stack.push(new RomanInteger(400, "CD"));
        stack.push(new RomanInteger(500, "D"));
        stack.push(new RomanInteger(900, "CM"));
        stack.push(new RomanInteger(1000, "M"));

        while(a > 0 && !stack.isEmpty()){
            RomanInteger romanInt = stack.peek();
            if(romanInt.value > a){
                stack.pop();
                continue;
            }
            sb.append(romanInt.ch);
            a-= romanInt.value;
        }

        return sb.toString();
    }

    class RomanInteger{
        int value;
        String ch;

        public RomanInteger(int i, String c){
            this.value = i;
            this.ch = c;
        }
    }
}
