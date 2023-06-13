package array.questions;

public class StringToInteger {
    public static int myAtoi(String s) {
        int i = 0;
        int result = 0;
        int sign = 1;


        if(i < s.length() && s.charAt(i) == ' '){
            i++;
        }

        if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            if(s.charAt(i++) == '-'){
                sign = -1;
            }
        }

        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){

                int digit = c - '0';

                if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit >                                       Integer.MAX_VALUE%10)){
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + digit;
            }
            i++;
        }
        return result * sign;
    }

    public static void main(String[] args){
        String s = "   -42";
        System.out.println(myAtoi(s));
    }
}
