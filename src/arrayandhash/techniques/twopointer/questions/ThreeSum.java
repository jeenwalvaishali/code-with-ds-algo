package arrayandhash.techniques.twopointer.questions;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
*/


import java.util.*;
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k = j+1; k<n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.sort(null);
                        if(!result.contains(triplet)){
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }


    public static List<List<Integer>> threeSumAlt(int[] nums){
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i =0; i<n-2; i++){
            if(i==0 || (i > 0  && nums[i] != nums[i-1])){
                int left = i+1, right = n-1, target = -nums[i];

                while(left < right){
                    int sum = nums[left] + nums[right];
                    if(sum == target){
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while (left < right && nums[right] == nums[right -1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum < target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        //Output: [[-1,-1,2],[-1,0,1]]
        int[] nums =  {-1,0,1,2,-1,-4};
        List<List<Integer>> output = threeSumAlt(nums);
        System.out.println(output);
    }
}
