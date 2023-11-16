package arrayandhash.questions;
/*Given an array of integers, find the duplicate elements in the array.
This problem can be solved in multiple ways, but you should aim for an efficient solution with a time complexity better than O(n^2).*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FindingDuplicates {

    public static List<Integer> findDuplicate(int[] nums){
        List<Integer> result = new ArrayList<>();

        for (int num : nums){
            int index = Math.abs(num) -  1;

            if(nums[index] < 0){
                result.add(index + 1);
            }else {
                nums[index] = -nums[index];
            }
        }

        return result;
    }
//TC: o(n^2)

    public static List<Integer> findDuplicateEfficient(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums){
            if (set.contains(num)) {

                result.add(num);
            }else {
                set.add(num);
            }
        }

        return result;
    }

//TC:o(n)


/*Input: [1, 2, 3, 4, 2, 5]

Iteration 1:
  num = 1, index = 0, nums[0] is 1
  Negate nums[0] to -1

Iteration 2:
  num = 2, index = 1, nums[1] is -2
  Add 2 to the result

Iteration 3:
  num = 3, index = 2, nums[2] is 3
  Negate nums[2] to -3

Iteration 4:
  num = 4, index = 3, nums[3] is 4
  Negate nums[3] to -4

Iteration 5:
  num = 2, index = 1, nums[1] is -2 (already marked as a duplicate)
  Add 2 to the result

Iteration 6:
  num = 5, index = 4, nums[4] is 5
  Negate nums[4] to -5

Result: [2]*/




    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 5, 5};
        List<Integer> result = new ArrayList<>();

        result = findDuplicateEfficient(nums);
        System.out.println(result);

    }
}

/*
This Java code is meant to find duplicates in an array of integers. It uses a technique called the "Negation Method" to mark and identify duplicates in the array.
Here's an explanation of how the code works:

Create an ArrayList called result to store the duplicate values that are found.
Iterate through the input array nums using a for-each loop, where num represents each element in the array.
For each element num, calculate an index index using Math.abs(num) - 1. The Math.abs() function is used to handle negative numbers as well, ensuring the index is non-negative.
Check the value at the calculated index index in the nums array.

If nums[index] is already negative, it means that this index has been visited before, and num is a duplicate.
In this case, add index + 1 (to get the original value, as array indices are 0-based) to the result list.

If nums[index] is non-negative, it means this is the first time you're encountering this index.
To mark it as visited, negate nums[index] by setting it to its negative value.

Continue this process for all elements in the nums array.

Finally, return the result list, which contains all the values that have duplicates in the original nums array.*/
