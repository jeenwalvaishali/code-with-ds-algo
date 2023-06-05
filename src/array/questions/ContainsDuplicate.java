package array.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
            if(hashMap.get(nums[i]) > 1){
                return true;
            }
        }

        System.out.println(hashMap);
        return false;
    }

    public static boolean alternateMethod1(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static boolean alternateMethod2(int[] nums){
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums){
            if(hashMap.containsKey(num)){
                return true;
            }
            hashMap.put(num, 1);
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        boolean output = alternateMethod2(nums);
        System.out.println(output);
    }
}
