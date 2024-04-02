package arrayandhash.techniques.twopointer.implementation;
/*
Given a sorted array of integers, find two numbers in the array that add up to a given target.

Solution using the two-pointer technique:

1.Initialize two pointers, one pointing to the first element of the array and the other pointing to the last element of the array.
2.While the left pointer is less than the right pointer:
   a. If the sum of the values at the left and right pointers is equal to the target, return the indices of the two pointers.
   b. If the sum is less than the target, move the left pointer one step to the right.
   c. If the sum is greater than the target, move the right pointer one step to the left.
3.If no pair of values adds up to the target, return null or an empty array.
* */
/*leetCode 167. Two Sum II - Input Array Is Sorted*/
import java.util.Arrays;

public class TwoPointerApproach {

    public static int[] twoSums(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[] {nums[left],nums[right]};
            }else if (sum < target){
                left++;
            }else {
                right--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] maxSum = twoSums(nums, target);
        System.out.println(Arrays.toString(maxSum));
    }
}
