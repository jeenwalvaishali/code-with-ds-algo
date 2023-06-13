package array.questions;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {


//            if(digits[digits.length -1] + 1 == 10){
//                for(int i = 0; i < digits.length - 1; i++) {
//                    digits[i] = digits[i] + 1;
//                }
//            }else{
//                for(int i = 0; i < digits.length; i++) {
//                    digits[digits.length - 1] = digits[i] + 1;
//                }
//            }
        int i = digits.length-1;
        int carry = 0;
        while(i>=0){
            int num = 0;
            if(carry>0)
            {
                num = digits[i]+carry;
            }else{
                num = digits[i]+1;
            }
            if(num>9){
               digits[i] = num%10;
               carry = num/10;
            }else {
                digits[i] = num;
                carry = 0;
            }
            i--;
            if(carry==0){
                break;
            }
        }
        if(carry>0){
            int temp[] = new int[digits.length+1];
            temp[0] = carry;
            for(int j=1;j<digits.length;j++){
                temp[j] = digits[j];
            }
            return temp;
        }

        /*for(int i = 0; i < digits.length; i++) {
            if(digits[i] + 1 == 10){
                digits[i] = digits[i] + 1;
            }
        }

        digits[digits.length - 1] = digits[digits.length - 1] + 1;

        */

        return digits;


//        int digit = 0;
//
//        for(int i = 0; i < digits.length; i++){
//            digit = digit*10 + digits[i];
//        }
//
//        int sum = digit + 1;
//
//
//
//        String temp = Integer.toString(sum);
//        int[] intArray = new int[temp.length()];
//
//        for(int i = 0; i < temp.length(); i++){
//            intArray[i] = temp.charAt(i) - 48 ;
//        }
//
//        System.out.println(Arrays.toString(intArray));
//
//        return intArray;

    }

    public static void main(String[] args){
        int[] digits = {9,9,9};

        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}
