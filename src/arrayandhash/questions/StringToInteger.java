package arrayandhash.questions;

public class StringToInteger {
    public static int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int result = 0;
        int sign = 1;
        int INT_MAX = Integer.MAX_VALUE/10;


        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < n && (Character.isDigit(s.charAt(i)))){
            int digit = s.charAt(i) - '0';

            if (result > INT_MAX || (result == INT_MAX && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;

            i++;
        }

        return result * sign;
    }

    public static void main(String[] args){
        String s = "   -42";
        System.out.println(myAtoi(s));
    }
}
