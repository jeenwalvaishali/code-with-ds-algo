## LeetCode 933. Number of Recent Calls — Java Solution

Approach: Queue (FIFO)

Maintain a queue of ping timestamps. For each new timestamp `t`:

1. Add `t` to the queue.
2. Remove timestamps strictly less than `t - 3000`.
3. Return the queue size, representing calls in the range $[t-3000, t]$.

### Java Code

java
```

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
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

### Example

Input:

text
```
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
```

Output:

text
```
[null, 1, 2, 3, 3]
```

Explanation:

- `ping(1)` → `[1]` → returns `1`
- `ping(100)` → `[1, 100]` → returns `2`
- `ping(3001)` → `[1, 100, 3001]` → returns `3`
- `ping(3002)` → removes `1` because $1 < 2$; queue becomes `[100, 3001, 3002]` → returns `3`

### Complexity Analysis

- Time: Amortized $O(1)$ per `ping()` call, since each timestamp is added and removed at most once.
- Space: $O(n)$, where $n$ is the number of timestamps retained in the 3000-millisecond window.

Key point: Remove timestamps only when `timestamp < t - 3000`, not when they are equal, because the range includes both endpoints.

---

Good question! Let's understand why we use `LinkedList` in LeetCode 933 — Number of Recent Calls.

java
```
public RecentCounter() {
    queue = new LinkedList<>();
}
```

## 1. Why do we use `LinkedList`?

We need a Queue to store request timestamps in the order they arrive.

For example:

text
```
ping(1)     → [1]
ping(100)   → [1, 100]
ping(3001)  → [1, 100, 3001]
```

When a timestamp becomes too old, we remove it from the front of the queue.

Java's `LinkedList` implements the `Queue` interface and supports these operations efficiently:

- `offer(t)` — add a timestamp to the end.
- `peek()` — check the first timestamp without removing it.
- `poll()` — remove the first timestamp.

## 2. Why not use an ArrayList?

Consider this code:

java
```
List<Integer> list = new ArrayList<>();
```

An `ArrayList` is efficient for adding elements at the end, but removing the first element with `remove(0)` takes $O(n)$ time because the remaining elements must shift.

With a `LinkedList`, removing the first element using `poll()` takes $O(1)$ time.

| Operation | LinkedList as Queue | ArrayList |
| --- | --- | --- |
| Add at end | $O(1)$ | Amortized $O(1)$ |
| Remove from front | $O(1)$ | $O(n)$ |
| Read first element | $O(1)$ | $O(1)$ |

## 3. Could we use another data structure?

Yes! Java's `ArrayDeque` is often a better choice for implementing a queue because it generally has less overhead than `LinkedList`.

You can write:

java
```
import java.util.ArrayDeque;
import java.util.Queue;

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

This solution works the same way.

### Key takeaway

We use `LinkedList` because we need to add timestamps at the end and remove old timestamps from the front efficiently. However, `ArrayDeque` is also an excellent, and often preferred, choice for this problem.