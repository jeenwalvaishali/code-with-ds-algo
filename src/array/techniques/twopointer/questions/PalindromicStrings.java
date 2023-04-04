package array.techniques.twopointer.questions;
/*
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.

Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
* */

public class PalindromicStrings {
    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for(int left = 0; left<n; left++){
            for(int right = left; right<n; right++){
                if(isPalindrome(s, left, right))
                    count++;
            }
        }

        return count;
    }

    public static boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "abc";
        int countOfPalindromes = countSubstrings(s);
        System.out.println(countOfPalindromes);
    }

}

/*
we can solve this problem using the two-pointer approach. Here's one way to do it:
We can use two pointers left and right to consider all possible substrings of the given string s.
For each pair of indices (left, right), we check if the substring s[left:right+1] is a palindrome or not.
If it is, we increment the count of palindromic substrings.

To check if a substring is a palindrome, we can use another two-pointer approach.
We use two pointers l and r to compare characters at the beginning and the end of the substring.
We keep moving l to the right and r to the left until they meet at the center of the substring or until we find a pair of characters that are not equal.
* */