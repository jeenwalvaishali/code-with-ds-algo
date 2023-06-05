package string.techniques.CountingCharacters;

import java.util.HashMap;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
* */
public class UniqueCharacters {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
           char c = s.charAt(i);
           map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
           if(map.get(c) == 1){
               return i;
           }
        }
       return -1;
    }

    public static void main(String[] args){
        String str1 = "leetcode";
        String str2 = "loveleetcode";
        String str3 = "aabb";

        int output = firstUniqChar(str3);
        System.out.println("output: " + output);

    }

}
