package hash;

import java.util.*;

public class MaximumOfMex {

    /*Brute Force Solution*/

    // Function to calculate the MEX of a given set
    public static int calculateMex(Set<Integer> set) {
        int mex = 0;
        while (set.contains(mex)) {
            mex++;
        }
        return mex;
    }

    // Function to calculate the maximum sum of MEX values of two subsets
    public static int maxMexSumBruteForce(int[] arr) {
        int n = arr.length;
        int maxMexSum = 0;

        // Iterate over all possible subsets
        for (int i = 0; i < (1 << n); i++) {
            Set<Integer> subsetA = new HashSet<>();
            Set<Integer> subsetB = new HashSet<>();

            // Split array into subsetA and subsetB based on the binary representation of i
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subsetA.add(arr[j]);
                } else {
                    subsetB.add(arr[j]);
                }
            }

            // Calculate MEX for both subsets
            int mexA = calculateMex(subsetA);
            int mexB = calculateMex(subsetB);

            // Update the maximum sum of MEX values
            maxMexSum = Math.max(maxMexSum, mexA + mexB);
        }

        return maxMexSum;
    }

    /*Efficient Solution*/
    public static int maxMexSum(int[] arr) {
        // Count the frequency of each integer in the array
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int mexA = 0;
        int mexB = 0;

        // Find mexA
        while (count.getOrDefault(mexA, 0) > 0) {
            count.put(mexA, count.get(mexA) - 1);
            mexA++;
        }

        // Find mexB
        while (count.getOrDefault(mexB, 0) > 0) {
            count.put(mexB, count.get(mexB) - 1);
            mexB++;
        }

        return mexA + mexB;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 0};
        System.out.println(maxMexSum(arr));  // Output: 3
    }
}
