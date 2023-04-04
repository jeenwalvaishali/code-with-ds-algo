package array.rotation;

public class leftRotationByXPositions {

    public static void rotateArray(int[] arr, int size, int d){

        int[] temp = new int[size];
        int k = 0;

        for (int i=d; i<size; i++){
            temp[k] = arr[i];
            k++;
        }

        for (int i=0; i<d; i++){
            temp[k] = arr[i];
            k++;
        }

        for (int i=0; i<size; i++){
            arr[i] = temp[i];
        }

    }

    public static void printArray(int[] arr, int size){
        for (int i=0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        printArray(arr, arr.length);
        rotateArray(arr, arr.length, 2);
        printArray(arr, arr.length);
    }
}
