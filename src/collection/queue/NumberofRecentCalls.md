In an interview, explain your solution in this order: Approach → Why Queue → Walkthrough → Complexity.

## 1. Explain the approach

You can say:

"I use a queue to maintain the timestamps of recent requests. Whenever `ping(t)` is called, I add the current timestamp to the queue.

The problem asks me to count how many requests occurred in the inclusive time range `[t - 3000, t]`.

Since timestamps arrive in increasing order, the oldest timestamps are always at the front of the queue. I remove timestamps that are older than `t - 3000`. Once all outdated timestamps are removed, the size of the queue gives me the number of requests in the last 3000 milliseconds, including the current request."

## 2. Explain the code line by line

java
```
class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);

        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}
```

- `Queue<Integer> queue;` — Stores the timestamps of recent requests in FIFO order.
- `queue = new ArrayDeque<>();` — Initializes the queue.
- `queue.offer(t);` — Adds the current request's timestamp.
- `while (queue.peek() < t - 3000)` — Checks whether the oldest timestamp is outside the valid time window.
- `queue.poll();` — Removes the oldest timestamp if it is too old.
- `return queue.size();` — Returns the number of requests in the valid time window.

Important detail: The condition uses `<`, not `<=`, because a request at exactly `t - 3000` milliseconds is still valid.

## 3. Walk through an example

Suppose the calls are:

java
```
ping(1);
ping(100);
ping(3001);
ping(3002);
```

Call: `ping(1)`

Count = 1

Valid window: \[-2999, 1\]

Queue: `[1]`

Call: `ping(100)`

Count = 2

Valid window: \[-2900, 100\]

Queue: `[1, 100]`

Call: `ping(3001)`

Count = 3

Valid window: \[1, 3001\]

Queue: `[1, 100, 3001]`

Timestamp 1 is exactly at the boundary, so it remains.

Call: `ping(3002)`

Count = 3

Valid window: \[2, 3002\]

Queue after cleanup: `[100, 3001, 3002]`

Timestamp 1 is removed because 1 \< 2.

## 4. Explain time and space complexity

Time complexity: Amortized $O(1)$ per `ping()` call.

Although the `while` loop can remove multiple timestamps in one call, each timestamp is added once and removed at most once. Therefore, the total work across $n$ calls is $O(n)$, giving amortized $O(1)$ per call.

Space complexity: $O(w)$, where $w$ is the maximum number of timestamps retained in the 3000-millisecond window. In the worst case, this can be $O(n)$ if many requests arrive within that window.

## 5. Common follow-up interview questions

Q: Why use a queue instead of an ArrayList?

A: A queue naturally supports FIFO processing. We add new timestamps at the back and remove expired timestamps from the front efficiently.

Q: Why use a `while` loop instead of an `if` statement?

A: Multiple timestamps may have expired since the previous call. The `while` loop removes all expired timestamps, not just one.

Q: Why do we add the timestamp before removing expired ones?

A: The current request must be included in the count. Adding it first ensures the queue contains the current request when we calculate the result.

Q: Why is `peek()` safe here? Could the queue be empty?

A: After `offer(t)`, the queue contains at least the current timestamp. Therefore, `peek()` is non-null when the loop condition is evaluated.

## 6. Your 30-second interview answer

If the interviewer asks you to explain the solution briefly, say:

"I use a FIFO queue to store request timestamps in increasing order. For each ping, I add the current timestamp, then remove timestamps from the front while they are smaller than `t - 3000`. This keeps only requests in the inclusive interval `[t - 3000, t]`. The queue size is the answer. Each timestamp is inserted once and removed at most once, so the amortized time complexity is $O(1)$ per call, and the space complexity is $O(w)$, where $w$ is the maximum number of requests in the active window."

Interview tip: Don't just say "I use a queue." Explain why the queue works: timestamps arrive in increasing order, so expired requests always appear at the front and can be removed without checking every element.