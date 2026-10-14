package collection.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/*Reverse a Queue
Problem
Input:
[1, 2, 3, 4]

Output:
[4, 3, 2, 1]*/

public class ReverseAQueue {

     public static Queue<Integer> reverse(Queue<Integer> queue){

         Stack<Integer> stack = new Stack<>();

         while (!queue.isEmpty()){
             stack.push(queue.poll());
         }

         while (!stack.isEmpty()){
             queue.offer(stack.pop());
         }

         return queue;
     }

    public static void main(String[] args) {
         Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(1,2,3,4));

        System.out.println(reverse(queue));
    }
}
