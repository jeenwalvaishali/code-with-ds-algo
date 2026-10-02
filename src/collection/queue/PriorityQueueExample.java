package collection.queue;

import java.util.Collections;
import java.util.PriorityQueue;

/*By default, it's a min-heap.*/

/*PriorityQueue ⭐⭐⭐
Use when you need:

"Give me the smallest/largest/highest-priority item."*/

public class PriorityQueueExample {

    public static void main(String[] args) {
        minHeap();
        System.out.println("-------------");
        maxHeap();
    }

    public static void minHeap(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(50);
        minHeap.offer(10);
        minHeap.offer(30);
        minHeap.offer(20);

        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
    }

    public static void maxHeap(){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(50);
        maxHeap.offer(10);
        maxHeap.offer(30);

        System.out.println(maxHeap.poll());
    }

}
