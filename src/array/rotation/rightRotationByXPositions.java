package array.rotation;

public class rightRotationByXPositions {

    public static void rotateRight(int[] arr, int n, int k){
         k = k%n;

         for(int i=0; i<n; i++){
             if(i<k){
                 System.out.print(arr[n+i - k] + " ");
             }else {
                 System.out.print(arr[i-k] + " ");
             }
         }
        //System.out.println();
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int k = 3;

        rotateRight(arr,n,k);

    }
}
