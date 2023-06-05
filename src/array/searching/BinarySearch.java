package array.searching;
/*
Binary search can be implemented only on a sorted list of items. If the elements are not sorted already, we need to sort them first.

Binary Search Algorithm can be implemented in two ways which are discussed below.
1. Iterative Method
2. Recursive Method

The recursive method follows the divide and conquer approach.

The general steps for both methods are discussed below.

The array in which searching is to be performed is:
The binary search algorithm works as follows:

1. Identify the middle element of the sorted array or list.

2. Compare the middle element with the target value:
- If the middle element is equal to the target value, the search is successful, and the index of the target element is returned.
- If the middle element is greater than the target value, the target value must be in the left half of the search space. Repeat the search process on the left half.
- If the middle element is less than the target value, the target value must be in the right half of the search space. Repeat the search process on the right half.

3. Repeat steps 1 and 2 on the updated search space until the target value is found or the search space is empty.

* */

public class BinarySearch {

    public static int searchIterative(int[] arr, int left, int right, int num){
        while (left <= right){
           int mid = left + (right-left)/2;
           if (arr[mid] == num){
               return mid;
           }else if (arr[mid] < num){
               left = mid + 1;
           }else {
               right = mid - 1;
           }
        }
        return -1;
    }

    public static int searchRecursive(int[] arr, int left, int right, int num){
        while (left <= right){
            int mid = left + (right-left)/2;
            if (arr[mid] == num){
                return mid;
            }else if (arr[mid] < num){
                return searchRecursive(arr, mid+1, right, num);
            }else {
                return searchRecursive(arr, left, mid-1, num);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = { 2, 3, 4, 10, 40 };
        int left = 0;
        int right = arr.length-1;
        int num = 4;

        int result = searchRecursive(arr,left, right,num);
        if (result == -1){
            System.out.println("Output: " + num+" is not found in array");
        }else {
            System.out.println("Output: " + num+ " is found at " + result + " index");
        }
    }
}

/*
Time Complexities
Best case complexity: O(1)
Average case complexity: O(log n)
Worst case complexity: O(log n)

Space Complexity
The space complexity of the binary search is O(1).
* */