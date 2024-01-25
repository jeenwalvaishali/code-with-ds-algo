package arrayandhash.techniques.slidingwindowapproach.questions;

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
*/

public class LongestRepeatChrReplace {

    public static int longestRepeatString(String s, int k){
        int n = s.length();
        int[] charCount = new int[26];

        int maxLen = 0; // the variable to store length of the longest String.
        int maxCount = 0; // the maximum count of a single character in the current window.
        int uniqueChars = 0; // the count of unique characters in the current window.

        int left = 0;
        int right = 0;

        while (right < n){

            char rightChar = s.charAt(right);
            if (charCount[rightChar - 'A'] == 0){
                uniqueChars++;
            }

            charCount[rightChar - 'A']++;
            maxCount = Math.max(maxCount, charCount[rightChar - 'A']);


            while (uniqueChars > (maxCount + k)){
                char leftChar = s.charAt(left);
                charCount[leftChar - 'A']--;
                if (charCount[leftChar - 'A'] == 0){
                    uniqueChars--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right-left + 1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Example 1
//        String s1 = "ABAB";
//        int k1 = 2;
//        System.out.println("Example 1 Output: " + longestRepeatString(s1, k1));

        // Example 2
        String s2 = "AABABBA    ";
        int k2 = 1;
        System.out.println("Example 2 Output: " + longestRepeatString(s2, k2));
    }
}
