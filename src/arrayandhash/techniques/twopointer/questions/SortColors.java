package arrayandhash.techniques.twopointer.questions;

import java.util.Arrays;

/*
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
* */
public class SortColors {
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;

        while(i <= right){
            if(nums[i] == 0){
                swap(nums, left, i);
                left++;
                i++;
            } else if(nums[i] == 2){
                swap(nums, right, i);
                right--;
            }else{
                i++;
            }
        }

    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = {2,0,2,1,1,0};

        System.out.println("Array Before Sort: " + Arrays.toString(nums));
        sortColors(nums);
        System.out.println("Array After Sort: " + Arrays.toString(nums));
    }
}

/*
In this solution, we initialize the left pointer to point to the first element in the array and the right pointer to point to the last element in the array.
We also initialize i to 0, which represents the current index we are at in the array.
We then enter a loop that continues until i is greater than right. At each iteration of the loop, we check the value at index i in the array:
1.If it is 0, we swap the element at index i with the element at index left, increment left and i by 1,
since we know that all elements to the left of left are 0s.
2.If it is 2, we swap the element at index i with the element at index right, decrement right by 1,
since we know that all elements to the right of right are 2s. We do not increment i in this case,
since the element at index i may be a 0 that we have swapped to the left.
3.If it is 1, we simply increment i, since we know that all elements between left and i-1 are 1s.
After the loop terminates, the array will be sorted in place with all the 0s at the beginning, followed by all the 1s, followed by all the 2s.
* */
