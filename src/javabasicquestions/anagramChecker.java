package javabasicquestions;

import java.util.Arrays;
/*
242. Valid Anagram

Difficulty: Easy
Description: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
49. Group Anagrams

Difficulty: Medium
Description: Given an array of strings, group the anagrams together.
438. Find All Anagrams in a String

Difficulty: Medium
Description: Given two strings s and p, find all the start indices of p's anagrams in s. You can return the answer in any order.
567. Permutation in String

Difficulty: Medium
Description: Given two strings s1 and s2, return true if s2 contains a permutation of s1, otherwise return false.
383. Ransom Note

Difficulty: Easy
Description: Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine's letters.
266. Palindrome Permutation

Difficulty: Easy
Description: Given a string, determine if a permutation of the string could form a palindrome.
890. Find and Replace Pattern

Difficulty: Medium
Description: Given a list of strings and a pattern, return a list of words that match the given pattern.
451. Sort Characters By Frequency

Difficulty: Medium
Description: Given a string, sort it in decreasing order based on the frequency of characters.
791. Custom Sort String

Difficulty: Medium
Description: You are given two strings order and str. Sort the characters of str based on the order defined by order.
953. Verifying an Alien Dictionary

Difficulty: Easy
Description: Given a list of words and an alien dictionary's order of characters, return true if the words are sorted lexicographically according to the alien order.
*/

public class anagramChecker {
    public static boolean isAnagramFirst(String str1, String str2){
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        System.out.println(str1);
        System.out.println(str2);

        if(str1.length() != str2.length()){
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public static boolean isAnagramSecond(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        System.out.println(str1);
        System.out.println(str2);

        if(str1.length() != str2.length()){
            return false;
        }

        int[] charCount = new int[26];

        for(int i=0; i<str1.length(); i++){
            charCount[str1.charAt(i) - 'a']++;
        }

        for(int i=0; i<str2.length(); i++){
            charCount[str2.charAt(i) - 'a']--;
        }

        for (int count : charCount){
            if(count != 0){
                return false;
            }
        }

        return true;
    }




    public static void main(String[] args) {
        String str1 = "peek";
        String str2 = "keep";

        if (isAnagramSecond(str1, str2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }
}
