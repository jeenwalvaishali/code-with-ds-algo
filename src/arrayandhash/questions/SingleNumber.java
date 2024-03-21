package arrayandhash.questions;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
*/

public class SingleNumber {

    public static int singleNumber(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int i = 0;
        int singleNumber = 0;
        for (int j = 1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                singleNumber = nums[j];
            }
        }

        return singleNumber;
    }

    public static void main(String[] args){
        int[] nums = {4,1,2,1,2};
        int singleNumber = singleNumber(nums);
        System.out.println(singleNumber);

    }
}
