package crackingthecodeinterview.arraysandstrings;

import java.util.Arrays;

public class PermutationOfString {

    public static boolean permutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        //Array is used to store count of each char in the string "s"
        //Each index of the array corresponds to the ASCII value of a character.
        int[] letters = new int[128];

        // Iterating through chars of string s and increments the count of each char in the letters array.
        for (int i = 0; i<s.length(); i++){
            letters[s.charAt(i)]++;
        }

        //Iterating through chars of t and the count of that char in the letters array.
        for(int i = 0; i<t.length(); i++){
            letters[t.charAt(i)]--;

            //If the count becomes negative, it means that t has more occurrences of that character than s,
            // which means t cannot be a permutation of s, so the method returns false.
            if(letters[t.charAt(i)]< 0){
                return false;
            }
        }

        return true;
    }

    public static boolean permutationAlt(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        return sort(s).equals(sort(t));
    }

    public static String sort(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }



    public static void main(String[] args) {
        String s = "abcd";
        String t = "dabc";

        System.out.println("Strings are Permutation of each other " + permutationAlt(s, t));
    }
}
