package searching.questions;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
*/
public class FindClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0; int right = arr.length - k;
        while(left < right){
            int mid = left + (right-left)/2;
            if(x - arr[mid] > arr[mid+k] - x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = left; i<left+k; i++){
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = -1;

        List<Integer> result = findClosestElements(arr, k, x);
        System.out.println(result);
    }
}

/*
Problem Statement
You need to find k closest elements to a given value x from a sorted array arr.

Solution Overview
The solution uses a combination of binary search and a straightforward list construction to efficiently find the k closest elements. Here's a step-by-step breakdown:

Step-by-Step Explanation

Define the Search Range:
int left = 0, right = arr.length - k;
left and right define the range of indices in the array where the closest k elements can start. The initial range is from 0 to arr.length - k because if left was greater than this, there wouldn't be enough space for k elements.

Binary Search for Optimal Starting Index:
while (left < right) {
    int mid = left + (right - left) / 2;
    if (x - arr[mid] > arr[mid + k] - x) {
        left = mid + 1;
    } else {
        right = mid;
    }
}
This binary search aims to find the starting index where the k closest elements should be taken.
mid is the middle point in the current search range.
We compare the distance from x to the element at mid with the distance to the element mid + k. If x is closer to arr[mid + k], then the range should move right (left = mid + 1); otherwise, it should move left (right = mid).

Construct the Result List:
List<Integer> result = new ArrayList<>();
for (int i = left; i < left + k; i++) {
    result.add(arr[i]);
}
After the binary search determines the left index, we create a list and add k elements starting from left to left + k.

Return the Result:
return result;
Finally, we return the list of the k closest elements.

Key Points
Binary Search: This approach efficiently narrows down the starting index of the closest k elements using binary search, which operates in O(log(n)) time complexity.
Linear Time Construction: Constructing the result list takes linear time relative to k, making the overall time complexity O(k + log(n)).
Space Complexity: The space complexity is O(k) due to the storage of the result list.

Why This Approach Works
The sorted nature of the array allows us to leverage binary search effectively.
By comparing distances from x to the elements at mid and mid + k, we ensure that we are selecting the optimal starting point for the closest k elements.
*/