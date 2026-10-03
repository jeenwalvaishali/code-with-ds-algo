package collection.questions;

/* First Non-Repeating Character ⭐
Problem
Input:
"swiss"

Output:
'w'*/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating {

    public static Character find(String input){

        Map<Character, Integer> frequency = new LinkedHashMap<>();

        for (char c : input.toCharArray()){
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character,Integer> entry : frequency.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String input = "swiss";

        System.out.println(find(input));
    }
}
