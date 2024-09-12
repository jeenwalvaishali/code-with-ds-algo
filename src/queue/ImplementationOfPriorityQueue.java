package queue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ImplementationOfPriorityQueue {
//    public static void main(String[] args) {
//        Queue<Integer> numbers = new PriorityQueue<>();
//        numbers.offer(5);
//        numbers.offer(1);
//        numbers.offer(2);
//
//        System.out.println("Queue: " + numbers);
//
//        if (!numbers.isEmpty())
//        {
//            int accessedNumber = numbers.peek();
//            System.out.println("AccessedNumber: " + accessedNumber);
//        }
//
//        if(!numbers.isEmpty()){
//            int removedNumber =  numbers.poll();
//            System.out.println("Removed Number: " + removedNumber);
//        }
//
//        System.out.println("UpdatedQueue: " + numbers);
//
//    }

    public static void main(String[] args) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();

//        numbers.add(4);
//        numbers.add(2);
//
//        System.out.println("Queue: " + numbers);
//
//        numbers.offer(1);
//        System.out.println("UpdatedQueue: "  + numbers);
//
//        int number = numbers.peek();
//        System.out.println("AccessedNumber: " + number);

        numbers.add(4);
        numbers.add(2);
        numbers.add(1);

        System.out.println("Queue: " + numbers);

        Iterator<Integer> iterator = numbers.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(", ");
        }
    }


}
