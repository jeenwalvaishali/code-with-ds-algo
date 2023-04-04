package array.insertion;

public class InsertAtAnyPositionUnsorted {

    public static void insertAtAnyPosition(int[] arr, int position, int n, int value){

        for (int i = n-1; i>=position; i-- ){
            arr[i+1] = arr[i];
        }
        arr[position] = value;
    }

    public static void main(String[] args){
        int[] arr = new int[10];
        arr[0] = 10;
        arr[1] = 2;
        arr[2] = 7;
        arr[3] = 3;
        arr[4] = 5;

        int position = 2;
        int n = 5;
        int  value = 6;

        System.out.print("Before Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        // Inserting key at specific position
        insertAtAnyPosition(arr, position, n, value);
        n = n+1;

        System.out.print("\n\nAfter Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
