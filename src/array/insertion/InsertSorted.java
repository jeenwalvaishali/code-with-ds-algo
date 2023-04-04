package array.insertion;

public class InsertSorted {

    public static int insertInSortedArray(int[] arr, int n, int value, int capacity){
        if (n>capacity){
            return n;
        }

        int i;
        for (i = n-1; (i>=0 && arr[i]>value); i--){
            arr[i+1] = arr[i];
        }

        arr[i+1] = value;

        return (n+1);
    }

    public static void main(String[] args){
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 4;
        arr[3] = 5;
        arr[4] = 6;

        int capacity = arr.length;
        int n = 5;
        int value = 2;

        System.out.print("\nBefore Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        // Function call
        n = insertInSortedArray(arr, n, value, capacity);

        System.out.print("\nAfter Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
