package queue;

import java.util.*;

public class KMostFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("FrequencyMap: " + frequencyMap);

        // Priority queue (min-heap) to store elements by frequency
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        System.out.println("minheap after element store: " + minHeap);

        // Iterate over the frequency map
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            minHeap.offer(entry);
            System.out.println("minheap after element iterate: " + minHeap);
            if (minHeap.size() > k){
                minHeap.poll();
            }
            System.out.println("minheap after if cond: " + minHeap);
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()){
            result.add(minHeap.poll().getKey());
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> topK = topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + topK);
    }
}
/*1. ((a, b) -> a.getValue() - b.getValue())
This comparator orders elements in ascending order based on their values. Here's what it does:

If a.getValue() is less than b.getValue(), the result is negative, which means a should come before b.
If a.getValue() is greater than b.getValue(), the result is positive, meaning b should come before a.
If a.getValue() is equal to b.getValue(), the result is zero, and their order doesn't change.
This behavior makes the PriorityQueue act as a Min-Heap.
In a Min-Heap, the smallest element (based on getValue()) is always at the root and gets removed
first when polling from the queue.

MinHeap
PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
    new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

2. ((a, b) -> b.getValue() - a.getValue())
This comparator orders elements in descending order based on their values. Here's what it does:

If b.getValue() is less than a.getValue(), the result is negative, meaning b should come before a.
If b.getValue() is greater than a.getValue(), the result is positive, meaning a should come before b.
If b.getValue() is equal to a.getValue(), the result is zero, and their order doesn't change.
This behavior makes the PriorityQueue act as a Max-Heap. In a Max-Heap, the largest element
(based on getValue()) is always at the root and gets removed first when polling from the queue.

MaxHeap
PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
    new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

*/