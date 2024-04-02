package arrayandhash.questions;

//Write an algorithm that will check if all the words in an array are palindromes.
// For example, an input of ['racecar', 'noon', 'civic'] should return True, but an input of ['racecar', 'shoe', 'moon'] should return False

public class palindromeArray {

    public static boolean isPalindrome(String s){
        StringBuilder reverseString = new StringBuilder();
        for (int i = s.length()-1 ; i>=0; i--){
            reverseString.append(s.charAt(i));
        }

        return s.equals(reverseString.toString());
    }

    public static boolean checkAllPalindromes(String[] words){
        for (String word : words){
            if (!isPalindrome(word)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] arr1 = {"racecar", "noon", "civic"};
        String[] arr2 = {"racecar", "shoe", "moon"};

        System.out.println(checkAllPalindromes(arr1)); // Output: true
        System.out.println(checkAllPalindromes(arr2)); // Output: false
    }
}
