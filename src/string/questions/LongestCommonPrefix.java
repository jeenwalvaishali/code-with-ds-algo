package string.questions;
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs){
        String commonPrefix = "";
        if(strs == null || strs.length == 0){
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++){
            char charToMatch = strs[0].charAt(i);

            for (int j = 1; j<strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != charToMatch){
                    return commonPrefix;
                }

                commonPrefix = commonPrefix + charToMatch;
            }
        }


        return commonPrefix;
    }

}

/*
The outer loop iterates through each character of the first string (strs[0]).
The inner loop iterates through each string in the array, starting from the second string (strs[1]).
It compares the character at the current index i in the first string with the corresponding character in other strings.
If a mismatch is found or the index i exceeds the length of any string, it means the common prefix ends, and the method returns the current commonPrefix.
If no mismatch is found, the character is added to the commonPrefix.
*/
