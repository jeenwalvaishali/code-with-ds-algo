package arrayandhash.techniques.traversingfromtheright.implementation;

import java.util.Arrays;

/*
Traversing an array from the right means starting the iteration from the last element of the array and moving towards the first element.
This approach is useful when we need to perform certain operations on the elements of an array that depend on the elements to the right of the current element.

For example, consider the problem of replacing each element in an array with the maximum of all the elements to the right of that element.
If we traverse the array from left to right, we will need to compute the max of all elements to the right of each element,
which would require nested loops and result in an O(n^2) time complexity. However, if we traverse the array from right to left,
we can keep track of the product of all elements to the right of each element as we move towards the left. This approach results in an O(n) time complexity.
* */

public class TraversingFromTheRight {

    public static int[] replaceElements(int[] arr){
        int n = arr.length;
        int max = -1;

        for (int i=n-1; i>=0; i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr  = {1, 2, 3, 4};
        int[] newArr = replaceElements(arr);
        System.out.println(Arrays.toString(newArr));
    }

}


/*
This function replaces each element in the array arr with the maximum element to its right.
We start from the rightmost element of the array, set a variable max to -1, and then iterate from right to left.
For each element, we first store its value in a temporary variable temp, set its value to max,
and then update max to be the maximum of its previous value and temp. After the iteration,
each element in the array will contain the maximum element to its right.
*/