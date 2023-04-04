package array.sorting;

public class BubbleSort {

    public static void bubbleSort(int[] arr){
        int n = arr.length;

        for (int i=0; i<n-1; i++){

            for (int j=0; j<n-i-1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    /* Prints the array */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] arr = { -2, 45, 0, 11, -9  };
        bubbleSort(arr);
        System.out.println("Sorted array");
        printArray(arr);
    }
}
