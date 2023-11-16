package arrayandhash.questions;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
           int n = nums.length;
           int count = 0;

           for(int i =0; i<n; i++){
               if(nums[i] != 0){
                   nums[count] = nums[i];
                   count++;
               }
           }

           while(count<n){
             nums[count] = 0;
             count++;
           }
    }

    public static void moveZeroes2(int[] nums){
        int j = 0;
        for (int i =0; i< nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}