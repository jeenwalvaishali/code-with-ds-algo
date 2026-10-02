package collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/*This pattern is extremely useful for:

stock prices
recent requests
logs
events
rate limiting
metrics
monitoring*/

public class SlidingWindowDequeExample {

    public static void main(String[] args){

        Deque<Integer> window = new ArrayDeque<>();

        int[] values = {10, 20, 30, 40, 50};

        int windowSize = 3;

        for (int value : values){
            window.addLast(value);

            if (window.size() > windowSize){
                window.removeFirst();
            }

            System.out.println(window);
        }
    }
}
