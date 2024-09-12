package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementationOfQueueInterface {

    public static void main(String[] args) {
        //Creating queue using LinkedList class
        Queue<Integer> numbers = new LinkedList<>();

        //offers element to the queue
        numbers.offer(1);
        numbers.offer(2);
        numbers.offer(3);

        //printing elements of queue
        System.out.println("Queue: " + numbers);

        //Access elements of queue
        if (!numbers.isEmpty()){
            int accessedNumber = numbers.peek();
            System.out.println("Accessed Element: " + accessedNumber);
        }

        //Removed element of queue
        if (!numbers.isEmpty()){
            int removedNumber = numbers.poll();
            System.out.println("Removed Number: " + removedNumber);
        }

        System.out.println("Updated Queue " + numbers);


    }
}
