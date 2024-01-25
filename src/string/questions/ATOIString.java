package string.questions;
/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.


Example 1:

Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
The parsed integer is 42.
Since 42 is in the range [-231, 231 - 1], the final result is 42.
Example 2:

Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.
Example 3:

Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
         ^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
The parsed integer is 4193.
Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
*/

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

/*
A “signed” (positive/negative) int whose value is represented in 32 bits
Because bits are binary (either a 0 or a 1), it’s a string of 32 0’s and 1's
If it’s a positive int, the leading bit is a 0; if negative, leading bit is a 1 — that’s called the integer’s “sign bit”
Since one bit is the “sign”, there are 31 bits left as the magnitude of the int
So, the largest value is 2³¹-1 and the smallest value is -(2³¹)
Then, I learned that an overflow (“integer overflow”) is when we attempt to store a value outside of a given range (in this case, 32-bits).
When this happens, we lose data because the object doesn’t have the memory to store it all.
*/