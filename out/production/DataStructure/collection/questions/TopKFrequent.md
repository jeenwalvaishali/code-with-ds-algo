This solution solves Top K Frequent Elements using a `HashMap` and a `Min Heap (PriorityQueue)`.

The main idea is: Count how often each number appears, then use a min heap to keep only the `k` most frequent numbers.

Let's break it down step by step.

## 1. Understand the problem

Given an integer array `nums` and an integer `k`, return the `k` numbers that appear most frequently.

Example:

java
```
nums = [1, 1, 1, 2, 2, 3]
k = 2
```

The frequencies are:

| Number | Frequency |
| --- | --- |
| 1 | 3 |
| 2 | 2 |
| 3 | 1 |

The two most frequent numbers are `1` and `2`.

Output:

java
```
[1, 2]
```

## 2. Step 1: Count the frequency of each number

java
```
Map<Integer, Integer> frequencyMap = new HashMap<>();

for (int num : nums) {
    frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
}
```

We use a `HashMap` where:

- Key: The number.
- Value: How many times that number appears.

### How `getOrDefault()` works

java
```
frequencyMap.getOrDefault(num, 0) + 1
```

- If `num` already exists in the map, get its current frequency and add `1`.
- If it doesn't exist, use `0` and add `1`.

For our example, the map becomes:

After processing all elements

Key: `1`

### Value: 3

Key: `2`

### Value: 2

Key: `3`

### Value: 1

Now we know how frequently each unique number appears.

## 3. Step 2: Create a min heap

java
```
PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
    new PriorityQueue<>(
        (a, b) -> a.getValue() - b.getValue()
    );
```

This is the most important part of the solution.

### What are we storing in the heap?

Each entry from the map contains a number and its frequency.

For example:

java
```
1 -> 3
2 -> 2
3 -> 1
```

We store these map entries in the priority queue.

### How does the comparator work?

java
```
(a, b) -> a.getValue() - b.getValue()
```

The comparator compares the frequencies, not the actual numbers.

- Lower frequency = higher priority to be removed.
- Higher frequency = stays longer in the heap.

For example, if the heap contains:

text
```
Number    Frequency
   1          3
   2          2
   3          1
```

The number `3` has the smallest frequency, so it will be at the top of the min heap.

Calling `minHeap.poll()` removes that least-frequent entry.

## 4. Step 3: Keep only the `k` most frequent elements

java
```
for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
    minHeap.offer(entry);

    if (minHeap.size() > k) {
        minHeap.poll();
    }
}
```

This loop processes every unique number in the frequency map.

For each entry:

1. Add it to the min heap using `offer()`.
2. Check whether the heap contains more than `k` elements.
3. If it does, remove the entry with the smallest frequency using `poll()`.

Why do we remove elements when the heap size exceeds `k`?

Because we only want to retain the `k` most frequent elements.

Let's trace the example with `k = 2`. For illustration, suppose the entries are processed in the order `1`, `2`, `3`.

### Heap walkthrough

Step 1: Add `1 → 3`

Size: 1

`[(1, 3)]`

The heap has fewer than 2 elements. Keep it.

Step 2: Add `2 → 2`

Size: 2

`[(2, 2), (1, 3)]`

The heap has exactly 2 elements. Keep both.

Step 3: Add `3 → 1`

Size: 3

Before removal: `[(3, 1), (2, 2), (1, 3)]`

The heap has 3 elements, exceeding k = 2. Remove `(3, 1)`, the entry with the lowest frequency.

Remaining heap: `(2, 2)` and `(1, 3)`

The final heap contains only numbers `1` and `2`, the two most frequent elements.

Key insight: The min heap automatically discards the least frequent number whenever it grows beyond size `k`. This way, you never need to store all unique numbers in the heap at once.

## 5. Step 4: Build the result array

java
```
int[] result = new int[k];

for (int i = k - 1; i >= 0; i--) {
    result[i] = minHeap.poll().getKey();
}

return result;
```

At this point, the heap contains exactly `k` entries.

Let's understand each line.

### Create an array of size `k`

java
```
int[] result = new int[k];
```

For `k = 2`, we create:

text
```
[0, 0]
```

### Remove entries from the heap

java
```
for (int i = k - 1; i >= 0; i--) {
    result[i] = minHeap.poll().getKey();
}
```

Remember, `poll()` removes the entry with the smallest frequency first.

In our example:

- First `poll()` returns `(2, 2)`, so `result[1] = 2`.
- Second `poll()` returns `(1, 3)`, so `result[0] = 1`.

The result becomes:

text
```
[1, 2]
```

### Why iterate backward?

Because the min heap returns elements from lowest frequency to highest frequency.

By filling the array from right to left, the most frequent element ends up toward the beginning.

For example:

| Poll order | Frequency | Array position |
| --- | --- | --- |
| `2` | 2 | `result[1]` |
| `1` | 3 | `result[0]` |

This produces `[1, 2]`, ordered from higher frequency to lower frequency in this example.

Note that the problem generally does not require a specific order among the returned elements.

## 6. Complete solution

Here is your code with explanatory comments:

java
```
public int[] topKFrequent(int[] nums, int k) {

    // Step 1: Count frequency of each number
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    for (int num : nums) {
        frequencyMap.put(
            num,
            frequencyMap.getOrDefault(num, 0) + 1
        );
    }

    // Step 2: Create a min heap ordered by frequency
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
        new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

    // Step 3: Keep only the k most frequent entries
    for (Map.Entry<Integer, Integer> entry
            : frequencyMap.entrySet()) {

        minHeap.offer(entry);

        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    // Step 4: Extract the k numbers into the result array
    int[] result = new int[k];

    for (int i = k - 1; i >= 0; i--) {
        result[i] = minHeap.poll().getKey();
    }

    return result;
}
```

## 7. Time and space complexity

Let:

- $n$ = number of elements in `nums`.
- $m$ = number of distinct numbers in `nums`.
- $k$ = number of elements to return.

| Operation | Complexity |
| --- | --- |
| Build the frequency map | $O(n)$ average |
| Process distinct entries in the heap | $O(m \log k)$ |
| Extract the result | $O(k \log k)$ |
| Total time | $O(n + m\log k)$ |
| Space | $O(m+k)$ |

Since $k \le m$, the extraction cost is covered by $O(m\log k)$ when $k \ge 2$. More precisely, the total time is $O(n + m\log k)$ for $k \ge 2$, and $O(n)$ for $k = 1$.

The frequency map takes $O(m)$ space, and the heap takes at most $O(k)$ space.

## 8. Why use a min heap instead of sorting?

This is a common interview question.

- Sorting: Sort all $m$ unique entries by frequency, taking $O(m\log m)$ time.
- Min heap: Keep only the best `k` entries, taking $O(m\log k)$ time.

When `k` is much smaller than the number of distinct elements, the heap can be significantly more efficient.

For example, if there are 100,000 distinct numbers but you only need the top 3, the heap never grows beyond 4 elements during processing.

One important detail: your comparator can be written more safely as:

java
```
(a, b) -> Integer.compare(a.getValue(), b.getValue())
```

This avoids the possibility of integer overflow from subtracting two integer values.

## The key idea to remember for interviews

HashMap + Min Heap of size `k`:

1. Count occurrences using a `HashMap`.
2. Insert each distinct number and its frequency into a min heap.
3. If the heap grows beyond `k`, remove the least frequent entry.
4. Extract the remaining `k` numbers into the result array.

The pattern is useful whenever you need the top `k` largest, most frequent, or highest-priority items without sorting every element.