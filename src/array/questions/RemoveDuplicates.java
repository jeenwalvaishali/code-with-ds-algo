package array.questions;

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

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        Set<Integer> hashSet = removeDuplicates(nums);
        System.out.println(hashSet);
    }
}
