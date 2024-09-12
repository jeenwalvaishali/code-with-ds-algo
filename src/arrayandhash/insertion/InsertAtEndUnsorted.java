package arrayandhash.insertion;

public class InsertAtEndUnsorted {

    public static int insertAtEnd(int[] arr, int capacity, int n, int value){

        if (n>=capacity){
            return n;
        }

        arr[n] = value;

        return (n+1);
    }

    public static void main(String[] args){

        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;

        int n = 6;
        int capacity = arr.length;
        System.out.println(capacity);
        int value = 7;

        System.out.print("Before insertion:  ");
        for (int i = 0; i<n; i++){
            System.out.print(arr[i] + " ");
        }

        n = insertAtEnd(arr,capacity,n,value);

        System.out.print("After insertion:  ");
        for (int i = 0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
