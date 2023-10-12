package string.questions;

import java.util.Arrays;

public class ReverseString {
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;

        while(start<end){
            char c = s[start];
            s[start] = s[end];
            s[end] = c;

            start++;
            end--;
        }
    }

    public static void main(String[] args){
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("original string" + Arrays.toString(s));
        reverseString(s);
        System.out.println("reverse string" + Arrays.toString(s));
    }
}
