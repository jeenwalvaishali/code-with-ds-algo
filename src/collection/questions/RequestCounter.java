package collection.questions;

/*Problem
A service receives requests.

Return the number of requests received in the last 60 seconds.*/

import java.util.ArrayDeque;
import java.util.Deque;

public class RequestCounter {

    private static Deque<Long> timeStamps = new ArrayDeque<>();

    public void recordRequest(long timeStamp){
        removeExpired(timeStamp);
        timeStamps.addLast(timeStamp);
    }

    public int getRequestCount(long timeStamp){
        removeExpired(timeStamp);
        return timeStamps.size();
    }

    public void removeExpired(long currentTime){
        while (!timeStamps.isEmpty() && timeStamps.peekFirst() <= currentTime- 60){
            timeStamps.removeFirst();
        }
    }

    public static void main(String[] args) {
        RequestCounter counter = new RequestCounter();
        counter.recordRequest(10);
        counter.recordRequest(20);
        counter.recordRequest(30);

        System.out.println(counter.getRequestCount(50));

    }
}
