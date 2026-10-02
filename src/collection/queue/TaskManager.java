package collection.queue;

import java.util.PriorityQueue;

public class TaskManager {

    public static void main(String[] args) {
        PriorityQueue<Task> tasks = new PriorityQueue<>((a,b) -> Integer.compare(b.priority , a.priority));

        tasks.offer(new Task(1, 5));
        tasks.offer(new Task(2, 10));
        tasks.offer(new Task(3, 3));

        while (!tasks.isEmpty()){
            Task task = tasks.poll();

            System.out.println("id: " + task.id + ", priority: " + task.priority);
        }

    }
}
