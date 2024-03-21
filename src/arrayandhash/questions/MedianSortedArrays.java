package arrayandhash.questions;
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
*/
public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] num3 = new int[n];

        int i =0, j =0, k = 0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] <nums2[j]){
                num3[k] = nums1[i];
                i++;
            }else {
                num3[k] = nums2[j];
                j++;
            }

            k++;
        }

        while(i<nums1.length){
            num3[k] = nums1[i];
            i++;
            k++;
        }

        while(j<nums2.length){
            num3[k] = nums2[j];
            j++;
            k++;
        }

        if (n%2==0){
            return (num3[n/2] + num3[n/2-1])/2.0;
        }else {
            return num3[n/2];
        }


    }
}
