package queue;
/*
Problem Description
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance, which is calculated as: (i.e., √(x1 - x2)2 + (y1 - y2)2). You may return the answer in any order.
The answer is guaranteed to be unique (except for the order that it is in).

Example 1:
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance of [1,3] from the origin is (sqrt{10}).
The distance of [-2,2] from the origin is (sqrt{8}).
Since (sqrt{8} < sqrt{10}), [-2,2] is the closest point.

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation:
The distance of [3,3] from the origin is (sqrt{18}).
The distance of [5,-1] from the origin is (sqrt{26}).
The distance of [-2,4] from the origin is (sqrt{20}).
The two closest points are [3,3] and [-2,4].
*/


import java.util.PriorityQueue;

public class kClosestToOrigin {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0] * b[0] + b[1] * b[1])-  (a[0] * a[0] + a[1] * a[1]));

        for(int[] point : points){
            maxHeap.offer(point);
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        while (k-->0){
            result[k] = maxHeap.poll();
        }

        return result;
    }
}
