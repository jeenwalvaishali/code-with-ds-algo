package string.questions;
/*
Given a string check if it is a Palindrome or not?
Example:
Input : str = "abba"
Output: Yes

Input : str = "abbca"
Output: No
* */

import java.util.Stack;

public class PalindromeString {

    public static boolean isPalindrome(String str){
        int i=0, j=str.length()-1;
        while (i<j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome2(String str){
        String reverseString = "";
        int n = str.length();
        for (int i=n-1; i>=0; i--){
            reverseString = reverseString + str.charAt(i);
        }

        return str.equals(reverseString);
    }


    public static void main(String[] args){
          String str = "abcba";
          boolean result = isPalindrome(str);

        System.out.println(str + " is palindrome: " + result);
    }

}


