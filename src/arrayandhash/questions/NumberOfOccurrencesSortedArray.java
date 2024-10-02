package arrayandhash.questions;

import java.util.HashMap;

/*Given a sorted array of n elements, possibly with duplicates, find the number of occurrences of the target element.
Example 1:
Input: arr = [4, 4, 8, 8, 8, 15, 16, 23, 23, 42], target = 8
Output: 3

Example 2:
Input: arr = [3, 5, 5, 5, 5, 7, 8, 8], target = 6
Output: 0

Example 3:
Input: arr = [3, 5, 5, 5, 5, 7, 8, 8], target = 5
Output: 4
*/
public class NumberOfOccurrencesSortedArray {

    public static int numberOfOccurrence(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if(map.containsKey(target)){
            return map.get(target);
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 5, 5, 5, 7, 8, 8};

        int target = 5;

        int result = numberOfOccurrence(arr, target);

        System.out.println(result);
    }
}
