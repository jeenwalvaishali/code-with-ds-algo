package collection.questions;

/*Input:
[2, 7, 11, 15]
target = 9

Output:
[2, 7]*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoPointerExample {

    public static int[] twoSums(int[] nums, int target){

        for (int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
    }

    public static int[] twoSumsAlt(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int difference = target - nums[i];

            if (map.containsKey(difference)){
                return new int[] {map.get(difference), i};
            }

            map.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {

        int[] nums= {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSums(nums, target)));

    }
}
