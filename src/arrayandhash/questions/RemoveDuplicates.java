package arrayandhash.questions;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static  Set<Integer> removeDuplicates(int[] nums) {
        Set<Integer> hashSet = new HashSet<Integer>();

        for(int i = 0; i<nums.length; i++){
            if(!hashSet.contains(nums[i])){
                hashSet.add(nums[i]);
            }
        }
      return hashSet;
    }

    public static int removeDuplicatesArray(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = 1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
       return i+1;
    }

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

//        Set<Integer> hashSet = removeDuplicates(nums);
        int result = removeDuplicatesArray(nums);
        System.out.println(result);
    }
}

/*Summary
removeDuplicates method has a time complexity of O(n) and a space complexity of O(n).
removeDuplicatesArray method has a time complexity of O(n) and a space complexity of O(1).*/