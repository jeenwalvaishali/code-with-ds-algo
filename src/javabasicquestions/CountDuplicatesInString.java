package javabasicquestions;
/*Write a java program to find duplicate characters and their count in a given string?
For example, in a string “Better Butter”, duplicate characters and their count is t : 4, e : 3, r : 2 and B : 2.*/


import java.util.HashMap;
import java.util.Map;

public class CountDuplicatesInString {

    public static void countDuplicate(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        char[] ch = str.toCharArray();
        for(char c: ch){
            if(c != ' '){
                c = Character.toUpperCase(c);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }


        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        countDuplicate("Better butter");
    }
}
