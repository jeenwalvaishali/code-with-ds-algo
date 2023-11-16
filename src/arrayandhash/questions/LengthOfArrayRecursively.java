package arrayandhash.questions;

public class LengthOfArrayRecursively {

    public static int arrLength(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;

       return arrLengthRecursion(arr, 0);
    }

    private static int arrLengthRecursion(int[] arr, int i) {
        if (i == arr.length)
            return 0;

        return 1 + arrLengthRecursion(arr, i+1);

    }


    public static void main(String[] args){
        int[] nums = {13, 2, 3, 44, 5, 7, 98, 19};

        int output = arrLength(nums);
        System.out.println("Output " + output);
    }
}
