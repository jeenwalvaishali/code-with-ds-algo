package arrayandhash.questions;

import java.util.*;

/*

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Map.Entry<Integer, Integer>: This represents an entry in a map where the key and value are both of type Integer.
In the context of the code, the key represents an element from the array, and the value represents the frequency of that element.

PriorityQueue<Map.Entry<Integer, Integer>>: This is a priority queue that stores entries from the map. The priority of elements in
this queue is determined by the values of the entries. In other words, the entries are ordered based on their frequencies in
ascending order. This is achieved by using a comparator that compares entries based on their integer values.

Here's a brief overview of how it's used in the given code:

java
Copy code
PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
    Comparator.comparingInt(Map.Entry::getValue));
minHeap: This is the priority queue that will be used to keep track of the k most frequent elements.

Comparator.comparingInt(Map.Entry::getValue): This sets up the comparator for the priority queue.
It compares entries based on their values (frequencies), and it's done in such a way that the entry with
the smallest value (frequency) comes first in the priority queue. This is important because we want to keep track of the
k most frequent elements.

This priority queue is then used in the subsequent loop to efficiently maintain the k most frequent elements as entries
are processed from the frequencyMap. The minHeap ensures that the entry with the smallest frequency is always at the front,
making it easy to identify and remove the least frequent element when the size of the heap exceeds k.
* */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry:: getValue));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()){
            result[index++]  = minHeap.poll().getKey();
        }


        return result;
    }
}
