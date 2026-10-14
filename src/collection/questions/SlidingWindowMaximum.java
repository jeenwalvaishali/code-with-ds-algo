package collection.questions;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static Deque<Integer> maxWindow(int[] nums, int k){

//        if(nums.length == 0 || k == 0){
//            return new int[0];
//        }

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i=0; i< nums.length; i++){




           deque.addLast(i);


        }

        System.out.println(deque.peekFirst());
        return deque;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(maxWindow(nums, k));
    }
}
