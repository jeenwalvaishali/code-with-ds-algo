package arrayandhash.techniques.slidingwindowapproach.questions;
/*
Given two strings s and t of lengths m and n respectively, return the minimum window
substring of s such that every character in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
* */


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t){

        Map<Character, Integer> freqT =  new HashMap<>();
        Map<Character, Integer> freqS =  new HashMap<>();

        for (char c : t.toCharArray()){
            freqT.put(c, freqT.getOrDefault(c, 0)+1);
        }

        int left = 0, right = 0, count = t.length(), minLength = Integer.MAX_VALUE;
        String minWindow = "";

        while (right < s.length()){
            char c = s.charAt(right);
            if (freqT.containsKey(c)){
                freqS.put(c, freqS.getOrDefault(c, 0) + 1);
                if (freqS.get(c) <= freqT.get(c)){
                    count--;
                }
            }
            right++;

            while (count == 0){
                if(right - left < minLength){
                    minLength = right - left;
                    minWindow = s.substring(left, right);
                }

                char leftChar = s.charAt(left);
                if (freqT.containsKey(leftChar)){
                    freqS.put(leftChar, freqS.get(leftChar) - 1);
                    if (freqS.get(leftChar) < freqT.get(leftChar)){
                        count++;
                    }
                }

                left++;
            }
        }
        return minWindow;
    }

}

