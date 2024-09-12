package arrayandhash.techniques.twopointer.questions;
/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

* */

import java.util.Arrays;

public class  MergeTwoArrays {

    public static void mergeSortedArrays(int[] num1, int m, int[] num2, int n){
       int i = m-1;
       int j = n-1;
       int k = m+n-1;

       while (i>=0 && j>=0){
           if (num1[i] > num2[j]){
               num1[k] = num1[i];
               i--;
           }else {
               num1[k] = num2[j];
               j--;
           }
           k--;
       }


       while (j>=0){
          num1[k] = num2[j];
          j--;
          k--;
       }

    }

    public static void main(String[] args){
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        int m = 3;
        int n = 3;

        mergeSortedArrays(num1,m,num2,n);

        System.out.println(Arrays.toString(num1));

    }

}

/*
In this implementation, we first initialize the pointers i, j, and k to the last elements of nums1, nums2, and the merged array respectively.
Then, we start comparing the elements at nums1[i] and nums2[j], and place the larger element at the end of the merged array (nums1[k]).
We then decrement the pointer corresponding to the larger element (i or j) and the merged array pointer (k), a
nd repeat the process until we have merged all the elements from nums2 into nums1.

Finally, if there are any remaining elements in nums2, we copy them into nums1.
* */
