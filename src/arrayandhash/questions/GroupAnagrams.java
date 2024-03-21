package arrayandhash.questions;

import java.util.*;
/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
*/
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hashmap = new HashMap<>();

        for (int i = 0; i<strs.length; i++){
            String str = strs[i];
            char[] strToArray = str.toCharArray();
            Arrays.sort(strToArray);
            String arrToString = String.valueOf(strToArray);

            if(!hashmap.containsKey(arrToString)){
                hashmap.put(arrToString, new ArrayList<>());
            }

            hashmap.get(arrToString).add(str);
        }

        return new ArrayList<>(hashmap.values());
    }

    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>>map = groupAnagrams(strs);
        System.out.println(map);
    }
}
