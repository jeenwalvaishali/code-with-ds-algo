package arrayandhash.questions;

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
