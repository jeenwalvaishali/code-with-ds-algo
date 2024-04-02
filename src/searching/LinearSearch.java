package searching;

/*Input: arr[] = {10, 20, 80, 30, 60, 50,110, 100, 130, 170}, x = 110;
Output: 6
Explanation: Element x is present at index 6
* */
public class LinearSearch {

    public static int search(int[] arr, int num){
        int length = arr.length;
        for(int i=0; i <=length; i++){
            if (arr[i] == num){
                return i;
            }
        }
        return -1;
    }

    public static int searchRecursive(int[] arr, int size, int num){
        if (size == 0){
            return -1;
        }

        if (arr[size-1] == num){
            return size-1;
        }else {
           return searchRecursive(arr, size-1, num );
        }

    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 80, 30, 60, 50,110, 100, 130, 170};
        int num = 110;
        int result = search(arr, num);
        int output = searchRecursive(arr, arr.length, num);
        if(result == -1){
            System.out.println("output: " + "Number is not present in the array");
        }
        System.out.println("output: " + result);

        if(result == -1){
            System.out.println("output: " + "Number is not present in the array");
        }
        System.out.println("output: " + output);
    }
}
// Time complexity of linear search is O(n)