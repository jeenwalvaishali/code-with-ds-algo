package collection.questions;
/*Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2] */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static int[] topFrequentK(int[] nums, int k){

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums){
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue() , b.getValue()));

        int[] result = new int[k];

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()){
            minHeap.offer(entry);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        for (int i = k-1; i>=0; i--){
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}
