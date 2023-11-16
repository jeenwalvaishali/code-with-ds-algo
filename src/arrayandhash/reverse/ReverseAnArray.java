package arrayandhash.reverse;
/*Given an array (or string), the task is to reverse the array/string.
Examples :
Input  : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}

Input :  arr[] = {4, 5, 1, 2}
Output : arr[] = {2, 1, 5, 4}
*
* */

public class ReverseAnArray {

    public static void reverseIterative(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void reverseRecursive(int[] arr, int start, int end){
        while (start >= end){
            return;
        }
        int temp = arr[start];
        arr[start]= arr[end];
        arr[end] = temp;
        reverseRecursive(arr, start+1, end-1);
    }

    public static void printArray(int[] arr, int size){
        for (int i=0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6};
        int size = arr.length;
        printArray(arr, size);
        reverseRecursive(arr, 0, size-1);
        System.out.print("Reversed array is \n");
        printArray(arr, arr.length);
    }
}
