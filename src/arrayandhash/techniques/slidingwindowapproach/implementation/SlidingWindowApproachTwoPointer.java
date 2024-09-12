package arrayandhash.techniques.slidingwindowapproach.implementation;

import java.util.HashSet;
import java.util.Set;
/*
The Sliding Window approach can also be implemented using two pointers. This approach is similar to the one I described earlier,
but instead of using a fixed-size window, we use two pointers to define the current subarray.

Here's an example of how to implement the Sliding Window approach using two pointers to find the longest substring with unique characters:

In this example, we use two pointers, left and right, to define the current subarray. We initialize both pointers to the first element of the string.
We also use a HashSet to keep track of the unique characters in the current subarray.
We then iterate through the string using the right pointer. If the current character is not in the HashSet,
we add it to the set and update the maxLength variable if necessary. We then move the right pointer to the next element.
If the current character is already in the HashSet, we remove the character at the left pointer from the HashSet and
move the left pointer to the next element. We continue this process until we reach the end of the string.
By using two pointers to define the current subarray, we can process each element of the string only once,
while maintaining a variable-length subarray. This allows us to solve problems efficiently, often in linear time.
* */
public class SlidingWindowApproachTwoPointer {

    public static int findLongestSubstring(String str){

        int n = str.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        Set<Character> set = new HashSet<>();
        while (right<n){
            if (!set.contains(str.charAt(right))){
                set.add(str.charAt(right));
                maxLength = Math.max(maxLength, set.size());
                right++;
            }else {
                set.remove(str.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args){
        String str = "abcabcbb";

        int maxSum = findLongestSubstring(str);
        System.out.println(maxSum);
    }
}
