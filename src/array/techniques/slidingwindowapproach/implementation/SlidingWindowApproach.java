package array.techniques.slidingwindowapproach.implementation;
/*# Sliding Window Approach

In this example, we define a sliding window of size k and initialize it to the first k elements of the array.
We then calculate the sum of the window and set it as the maximum sum. We then slide the window to the right by one element at a time,
recalculating the window sum and updating the maximum sum if necessary. Finally, we return the maximum sum.
*
*
In the Sliding Window technique, we use a fixed-size window or subarray to solve the problem.
To slide the window, we remove the first element of the current window and add the next element to the window.
This allows us to process each element of the array only once, while maintaining a fixed-size window.
In the code snippet I provided earlier, the line windowSum += arr[i] - arr[i - k]; is used to slide the window to the right by one element.
Let's break it down:
arr[i] represents the next element that we want to add to the window. We add it to the current window sum.
arr[i - k] represents the first element that we want to remove from the window. We subtract it from the current window sum.

The difference between arr[i] and arr[i - k] represents the effect of sliding the window by one element.
This difference is added to the current window sum, effectively removing the first element and adding the next element to the window.

By sliding the window in this way, we can process each element of the array only once,
while maintaining a fixed-size window. This allows us to solve problems efficiently, often in linear time.
* */
public class SlidingWindowApproach {

    public static int findMaxSumSubArray(int[] arr, int k){

        int n = arr.length;
        int maxSum = 0;
        int windowSum = 0;

        for(int i =0; i<k; i++){
            windowSum += arr[i];
        }

        maxSum = windowSum;

        for (int i = k; i<n; i++){
            windowSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum,windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args){
        int[] arr = {2,3,6,1,5,4};
        int k = 3;

        int maxSum = findMaxSumSubArray(arr, k);
        System.out.println(maxSum);
    }
}
