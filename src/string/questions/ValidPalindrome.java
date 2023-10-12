package string.questions;
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
* */

public class ValidPalindrome {
    public static boolean isValidPalindrome(String s){
        String str = s.replaceAll("[^a-zA-Z0-9]", "");
        String reverseString = "";
        int end = str.length()-1;
        int start = 0;
        for (int i=end; i>=start; i--){
            reverseString = reverseString + str.charAt(i);
        }

        if (str.toLowerCase().equals(reverseString.toLowerCase())){
            return true;
        }

        return false;
    }

    public static void  main(String[] args){
        String str = "A man, a plan, a canal: Panama";
        boolean output = isValidPalindrome(str);
        System.out.println(str + " is palindrome " + output);
    }
}
