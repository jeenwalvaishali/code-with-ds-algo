package arrayandhash.questions;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {

        int[] arr = new int[nums.length];
        int left = 1; int right = 1;

        for (int i = 0; i<nums.length; i++){
            arr[i] = left;
            left *= nums[i];
        }

        for(int i = nums.length-1; i>=0; i--){
            arr[i] *= right;
            right *= nums[i];
        }

        return arr;
    }

    public static int[] productExceptSelfAlternative(int[] nums) {
        int n = nums.length;

        // Initialize arrays to store products to the left and right of each element
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        // Calculate products to the left of each element
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            leftProducts[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Calculate products to the right of each element
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            rightProducts[i] = rightProduct;
            rightProduct *= nums[i];
        }

        // Calculate the final result by multiplying left and right products
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf(nums);

        System.out.println(Arrays.toString(result));
    }

}
