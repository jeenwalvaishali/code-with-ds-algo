package sorting;

public class SelectionSort {

    public static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i = 0; i<n-1; i++){
            int minInd = i;

            for (int j = i+1; j<n; j++){
                if (arr[j] < arr[minInd]){
                    minInd = j;
                }
            }

            int temp = arr[minInd];
            arr[minInd] = arr[i];
            arr[i] = temp;
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String[] args){

        int arr[] = {64,25,12,22,11};
        System.out.println("Array before sorting ");
        printArray(arr);
        System.out.println("Array after selection sort ");
        selectionSort(arr);
        printArray(arr);
    }
}
