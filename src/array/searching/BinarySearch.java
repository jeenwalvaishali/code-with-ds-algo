package array.searching;

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
