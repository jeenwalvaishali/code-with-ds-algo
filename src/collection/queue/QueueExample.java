package collection.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*Use a Queue when you process items in:

FIFO — First In, First Out

Think:

First person enters
        ↓
First person gets served*/

/*Important methods
offer() → add
peek()  → look at first
poll()  → remove first
Complexity
Usually:

offer() → O(1)
peek()  → O(1)
poll()  → O(1)*/

public class QueueExample {

    public static void main(String[] args){
        Queue<String> queue = new LinkedList<>();

        queue.offer("Alice");
        queue.offer("Bob");
        queue.offer("charlie");

        System.out.println(queue.peek());

        System.out.println(queue.poll());

        System.out.println(queue);

        queue.offer("Alice");

        Iterator<String> iterator = queue.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next() + " ");
        }

    }
}
