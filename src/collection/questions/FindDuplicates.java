package collection.questions;

/*Problem
Find all duplicate numbers.

Input:
[1, 2, 3, 2, 4, 1, 5]

Output:
[1, 2]*/

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    public static Set<Integer> findDuplicates(int[] nums){
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num: nums){
            if (!seen.add(num)){
                duplicates.add(num);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 1, 5};
        System.out.println(findDuplicates(nums));
    }
}
