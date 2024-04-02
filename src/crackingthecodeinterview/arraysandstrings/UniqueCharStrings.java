package crackingthecodeinterview.arraysandstrings;

// Implement an algorithm to determine if a String has all unique characters.
// what if you can not use additional data structures?

import java.util.HashSet;
import java.util.Set;

public class UniqueCharStrings {

    private static final int ASCII_CHAR = 256;

    public static boolean isUniqueChar(String str){
        if(str.length() > 128){
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++){
            int val = str.charAt(i);

            if (charSet[val]){
                return false;
            }

            charSet[val] = true;
        }

        return true;
    }

    public static boolean hasUniqueCharacters(String str) {
        if(str == null || str.isEmpty()){
            return false;
        }

        for (int i = 0; i<str.length(); i++){
            char currentChar = str.charAt(i);
            for (int j = i+1; j<str.length(); j++){
                if(currentChar == str.charAt(j)){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isUnique(String str){
        if(str.length() > ASCII_CHAR){
            return false;
        }

        Set<Character> hasSet = new HashSet<>(ASCII_CHAR);

        for (int i = 0; i<str.length(); i++){
            if (hasSet.contains(str.charAt(i))){
                return false;
            }

            hasSet.add(str.charAt(i));
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "hello";
        String str3 = "world";

        System.out.println("String \"" + str1 + "\" has all unique characters: " + isUnique(str1));
        System.out.println("String \"" + str2 + "\" has all unique characters: " + isUnique(str2));
        //System.out.println("String \"" + str3 + "\" has all unique characters: " + isUniqueChar(str3));
    }
}
