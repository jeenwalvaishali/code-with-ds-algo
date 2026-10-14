In an interview, the best way to explain this solution is to cover the approach, why you chose the data structure, how the code works, an example, and time and space complexity.

Here’s how you can explain it confidently.

## 1. Start by explaining the problem

You can say:

“We need to design a request counter that returns the number of requests received in the last 60 seconds. Whenever a new request arrives or we want to check the count, we need to remove requests that are older than the 60-second window.”

For example, if the current timestamp is `50`, we want to count requests in the last 60 seconds.

## 2. Explain your approach

“I am using a `Deque` implemented with `ArrayDeque` to store the timestamps of incoming requests.

The idea is to maintain only the timestamps that belong to the current 60-second window. Since requests are assumed to arrive in chronological order, the oldest timestamp is always at the front of the deque.

Before recording a new request or returning the count, I remove all expired timestamps from the front. After cleanup, the size of the deque gives me the number of requests in the window.”

### How the deque works

Oldest request

## 10

## 20

## 30

Newest request

- `addLast()` adds a new request at the back.
- `peekFirst()` checks the oldest timestamp.
- `removeFirst()` removes an expired request.
- `size()` returns the number of remaining requests.

## 3. Explain the code step by step

### A. Store timestamps

java
```
private static Deque<Long> timeStamps = new ArrayDeque<>();
```

- `Deque` is a double-ended queue.
- `ArrayDeque` provides efficient insertion and removal at both ends.
- `Long` stores timestamps as long integer values.

We use a deque because we only need to remove expired requests from the front and add new requests at the back.

### B. Record a request

java
```
public void recordRequest(long timeStamp) {
    removeExpired(timeStamp);
    timeStamps.addLast(timeStamp);
}
```

“When a request arrives, I first remove expired timestamps. Then I append the new timestamp to the end of the deque.”

This ensures the deque contains only valid requests, assuming requests arrive in chronological order.

### C. Get the request count

java
```
public int getRequestCount(long timeStamp) {
    removeExpired(timeStamp);
    return timeStamps.size();
}
```

“When we need the count, I first clean up expired requests. Then I return the deque's size, which represents the number of requests in the current window.”

### D. Remove expired timestamps

java
```
public void removeExpired(long currentTime) {
    while (!timeStamps.isEmpty()
            && timeStamps.peekFirst() <= currentTime - 60) {
        timeStamps.removeFirst();
    }
}
```

“This is the core logic. I calculate the expiration boundary using `currentTime - 60`. While the oldest timestamp is less than or equal to that boundary, I remove it.

I use a `while` loop because multiple requests may have expired.”

Important interview detail: Your condition uses `<=`, so a request exactly 60 seconds old is excluded. This means your code counts timestamps in the interval `(currentTime - 60, currentTime]`, assuming timestamps are in seconds. If the requirement considers the exact 60-second boundary inclusive, the condition would need to change.

## 4. Walk through the example

Your `main()` method records requests at timestamps `10`, `20`, and `30`, then asks for the count at timestamp `50`.

java
```
counter.recordRequest(10);
counter.recordRequest(20);
counter.recordRequest(30);

System.out.println(counter.getRequestCount(50));
```

At time `50`, the expiration boundary is:

$$
50 - 60 = -10
$$

| Timestamp | Is it expired? | Action |
| --- | --- | --- |
| 10 | No | Keep |
| 20 | No | Keep |
| 30 | No | Keep |

The deque contains `[10, 20, 30]`, so the output is:

text
```
3
```

Let's also consider a case where a request expires.

At time `75`, the expiration boundary is:

$$
75 - 60 = 15
$$

- Timestamp `10` is removed because `10 <= 15`.
- Timestamp `20` remains.
- Timestamp `30` remains.

The deque becomes `[20, 30]`, and the count is `2`.

## 5. Explain time and space complexity

This is a particularly important interview question.

| Operation | Complexity | Reason |
| --- | --- | --- |
| `recordRequest()` | Amortized $O(1)$ | Each timestamp is added once and removed at most once |
| `getRequestCount()` | Amortized $O(1)$ | Each timestamp is removed at most once over its lifetime |
| `removeExpired()` | $O(n)$ worst case per call | It may remove $n$ expired timestamps in one call |
| Space | $O(n)$ | Stores timestamps for requests still in the window |

Here, $n$ is the number of stored requests.

A good way to explain amortized $O(1)$:

“Although one call might remove several expired timestamps, each timestamp is inserted only once and removed only once. Therefore, across many operations, the total cleanup work is linear in the number of requests, giving amortized constant time per operation.”

## 6. Common follow-up interview questions

### Why use a deque instead of an ArrayList?

A deque lets us remove elements from the front efficiently. Removing the first element of an `ArrayList` requires shifting the remaining elements, which takes $O(n)$ time.

### Why use a while loop instead of an if statement?

Multiple timestamps may have expired. A `while` loop removes all expired timestamps before returning the count.

### What if no requests arrive for a long time?

The next call to `recordRequest()` or `getRequestCount()` removes all expired timestamps. The cleanup is lazy, meaning expired entries remain stored until the next operation.

### Does this solution work with out-of-order timestamps?

Not reliably. It assumes timestamps are inserted in chronological order. If an older timestamp is added at the back after a newer one, checking only the front may leave expired entries in the deque. We would need to enforce chronological ordering or use a different approach.

### Is this thread-safe?

No. The `ArrayDeque` is not thread-safe, and concurrent requests could cause race conditions. A production implementation handling concurrent requests would need synchronization or another suitable concurrency design.

## 7. A polished 60-second interview answer

Practice saying this in your own words:

Writing

I would solve this problem using a deque to store the timestamps of incoming requests.

The main idea is to maintain a sliding time window of 60 seconds. Whenever a request arrives or we need the current count, we first remove all expired timestamps from the front of the deque.

To determine whether a timestamp has expired, I compare it with `currentTime - 60`. If the oldest timestamp is less than or equal to this boundary, I remove it. I repeat this process using a while loop until the oldest timestamp is valid or the deque is empty.

When recording a request, I add its timestamp to the end of the deque. When retrieving the count, I return the deque's size after cleanup.

The advantage of this approach is that adding and removing timestamps from the ends of a deque is efficient. Each timestamp is inserted once and removed at most once, so the operations have amortized O(1) time complexity, with O(n) space complexity for the timestamps currently stored.

One assumption is that requests arrive in chronological order. If requests can arrive out of order, I would need to adjust the design.

Interview tip: Focus on the key idea: remove expired timestamps from the front, add new timestamps at the back, and return the deque's size. If you can explain why each step is needed, you understand the solution rather than just memorizing the code.