package arrayandhash.techniques.slidingwindowapproach.questions;

import java.util.HashMap;
import java.util.Map;
/*
Description
Given a string S, find the length of the longest substring T that contains at most k distinct characters.

Example
Example 1:

Input: S = "eceba" and k = 2
Output: 4
Explanation: T = "eceb"
Example 2:

Input: S = "WORLD" and k = 4
Output: 4
Explanation: T = "WORL" or "ORLD"
*/
public class LongestSubstringKDistinct {

    public static int longestSubstringKDistinct(String s, int k){

        if(s.length() == 0 || k == 0 || s == null){
            return 0;
        }

        Map<Character, Integer> charFrequency = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for(int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);

            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            while(charFrequency.size() > k){
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);

                if(charFrequency.get(leftChar) == 0){
                    charFrequency.remove(leftChar);
                }

                left++;

            }
           maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        int result = longestSubstringKDistinct(s, k);
        System.out.println("Longest substring with " + k + " distinct characters: " + result);
    }
}
