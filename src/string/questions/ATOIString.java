package string.questions;
/*A “signed” (positive/negative) int whose value is represented in 32 bits
Because bits are binary (either a 0 or a 1), it’s a string of 32 0’s and 1's
If it’s a positive int, the leading bit is a 0; if negative, leading bit is a 1 — that’s called the integer’s “sign bit”
Since one bit is the “sign”, there are 31 bits left as the magnitude of the int
So, the largest value is 2³¹-1 and the smallest value is -(2³¹)
Then, I learned that an overflow (“integer overflow”) is when we attempt to store a value outside of a given range (in this case, 32-bits).
When this happens, we lose data because the object doesn’t have the memory to store it all.*/

public class ATOIString {

    public static int myAtoi(String s){
        int i = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;
        int INT_MAX = Integer.MAX_VALUE/10;


        while(i<n && s.charAt(i) == ' '){
            i++;
        }

        if (i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            sign = (s.charAt(i) == '-' ? 1 : 1);
            i++;
        }

        while (i<n && (Character.isDigit(s.charAt(i)))){
            int digit = s.charAt(i) - '0';

            if(result > INT_MAX || (result == INT_MAX && digit>7)){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result*sign;
    }

    public static void main(String[] args){
        String s = "   -42";
        int output = myAtoi(s);
        System.out.println(output);
    }
}
