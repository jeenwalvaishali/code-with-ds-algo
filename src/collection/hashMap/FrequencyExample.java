package collection.hashMap;

import java.util.HashMap;
import java.util.Map;

/*Memorize this pattern:

map.put(key, map.getOrDefault(key, 0) + 1);*/

/*HashMap + frequency counting ⭐
This pattern appears constantly in coding interviews.

Problem:

Find how many times each number appears.*/

public class FrequencyExample {

    public static void main(String[] args){

        int[] numbers = {1, 2, 2, 3, 1, 2, 3, 3};

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int number: numbers){
            frequency.put(number, frequency.getOrDefault(number, 0) + 1);
        }

        System.out.println(frequency);
    }
}
