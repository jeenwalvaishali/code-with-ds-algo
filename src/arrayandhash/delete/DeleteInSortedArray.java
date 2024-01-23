package arrayandhash.delete;

public class DeleteInSortedArray {

    public static int binarySearch(int[] arr, int low,  int high, int key){
        if(high < low){
            return -1;
        }

        int mid =  (low+high)/2;
        if (key == arr[mid]){
            return mid;
        }

        if (key < arr[mid]){
            return binarySearch(arr, low, mid-1,  key);
        }else {
            return binarySearch(arr, mid+1, high, key);
        }
    }

    public static int deleteElement(int[] arr, int n, int key){

        int positionOfElement = binarySearch(arr, 0, n-1, key);

        if (positionOfElement == -1){
            System.out.println("Element not found");
            return n;
        }

        for (int i = positionOfElement; i<n-1; i++){
            arr[i] = arr[i+1];
        }
        return n-1;
    }

    public static void main(String[] args){

        int[] arr = {10, 20, 30, 40, 50 };

        int n = arr.length;
        int key = 50;

        System.out.println("Array before deleting an element:\n");
        for (int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }

        n = deleteElement(arr, n, key);

        System.out.println("\n\nArray after deleting an element:\n");
        for (int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

}
