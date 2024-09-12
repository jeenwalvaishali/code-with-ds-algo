package string.questions;
/*
Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
A string is palindromic if it reads the same forward and backward.

Example 1:
Input: words = ["abc","car","ada","racecar","cool"]
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.

Example 2:
Input: words = ["notapalindrome","racecar"]
Output: "racecar"
Explanation: The first and only string that is palindromic is "racecar".

Example 3:
Input: words = ["def","ghi"]
Output: ""
Explanation: There are no palindromic strings, so the empty string is returned.
*/
public class FirstPalindromeInStringArray {

    public String firstPalindrome(String[] words) {
        for(String word : words){
            if(isPalindrome(word)){
                return word;
            }
        }
        return "";
    }


    public boolean isPalindrome(String str){
        StringBuilder reverseStr = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            reverseStr.append(str.charAt(i));
        }
        return str.equals(reverseStr.toString());
    }

}

/*Summary
Time Complexity:
O(n×m)
Space Complexity:
O(n)*/
