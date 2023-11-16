package arrayandhash.questions;
/* Given an array of integers containing numbers from 1 to N, with one number missing, find the missing number.*/

public class MissingElements {
    public static int findMissingNumber(int[] nums){
        int n = nums.length;
        int totalSum = (n * (n + 1))/2;
        int actualSum = 0;

        for (int num : nums){
            actualSum = num + actualSum;
        }

        return totalSum - actualSum;
    }

    public static void main(String[] args) {
        int[] nums = { 9,6,4,2,3,5,7,0,1};
        int result = findMissingNumber(nums);

        System.out.println(result);
    }
}
