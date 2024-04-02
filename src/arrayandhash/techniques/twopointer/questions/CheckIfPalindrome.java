package arrayandhash.techniques.twopointer.questions;

public class CheckIfPalindrome {

    public static boolean checkIfPalindrome(String str){

        int left = 0;
        int right = str.length() - 1;

        while (left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "abcdcba";
        String str2 = "nbhcbn";

        System.out.println(str1 + " isPalindrome " + checkIfPalindrome(str1));
        System.out.println(str2 + " isPalindrome " + checkIfPalindrome(str2));
    }
}
