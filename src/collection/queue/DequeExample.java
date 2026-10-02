package collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/*Deque means:

Double Ended Queue

You can add/remove from both ends.*/

public class DequeExample {

    public static void main(String[] args){

        Deque<Integer> prices = new ArrayDeque<>();

        prices.addLast(100);
        prices.addLast(200);
        prices.addLast(300);

        System.out.println(prices);

        //First element
        System.out.println(prices.peekFirst());

        //Last element
        System.out.println(prices.peekLast());

        //Remove First
        prices.removeFirst();

        //Remove Last
        prices.removeLast();

        System.out.println(prices);

    }
}
