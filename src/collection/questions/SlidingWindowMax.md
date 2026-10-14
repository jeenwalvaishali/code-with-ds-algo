## Remember this trick

### int[] result = new int[nums.length - k + 1];
Subtracting gives you the last starting index. Adding 1 gives you the total number of starting positions.


---


Yes — this is probably the **most confusing line** in the solution:

```
deque.peekFirst() <= i - k
```

Let's break it down slowly.

## What is `deque` storing?

Remember, we're storing **indexes**, not values.

For:

```
nums = [1, 3, -1, -3, 5]
index   0  1   2   3  4
```

The deque might contain:

```
[1, 2]
```

That means:

```
nums[1] = 3
nums[2] = -1
```

---

## What does `i - k` mean?

We need to remove indexes that are **outside the current window**.

Suppose:

```
k = 3
```

and we're currently at:

```
i = 4
```

Our current window is:

```
indices: 2, 3, 4

[-1, -3, 5]
```

So index `1` is no longer part of the window.

Now calculate:

```
i - k
= 4 - 3
= 1
```

Therefore:

```
deque.peekFirst() <= i - k
```

becomes:

```
deque.peekFirst() <= 1
```

Meaning:

> If the index at the front of the deque is `1` or smaller, it has left the window.

So we remove it:

```
deque.pollFirst();
```

---

## Why `<=`?

Let's look at it visually.

For `i = 4`, `k = 3`:

```
Current window:

index:  0   1   2   3   4
        |       [       ]
                2   3   4
```

The valid indexes are:

```
2, 3, 4
```

Anything:

```
<= 1
```

is outside.

And:

```
1 = i - k
```

Therefore:

```
deque.peekFirst() <= i - k
```

---

## Another way to understand it

The current window always covers:

```
[i - k + 1, i]
```

For example, when:

```
i = 4
k = 3
```

the window is:

```
[4 - 3 + 1, 4]
[2, 4]
```

So:

```
2, 3, 4
```

are valid.

Anything **less than 2** is invalid.

The largest invalid index is:

```
1
```

And:

```
i - k = 1
```

Hence:

```
deque.peekFirst() <= i - k
```

---

### The whole line

```
while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
    deque.pollFirst();
}
```

In plain English:

> **"While the oldest index in my deque is no longer inside the current window, remove it."**

That's all this line is doing.

A useful thing to memorize is:

```
Current window = [i-k+1 ... i]

Expired indexes = <= i-k
```

Once you understand that, this condition becomes much less mysterious.

Let's break this code down step by step. The main idea is to find the maximum value in every window of size `k` using a Deque (double-ended queue).

For your example:

java
```
nums = [1, 3, -1, -3, 5, 3, 6, 7]
k = 3
```

The expected output is:

java
```
[3, 3, 5, 5, 6, 7]
```

## 1. What does the `for` loop do?

java
```
for (int i = 0; i < nums.length; i++) {
```

- `i` is the index of the current element.
- The loop visits every element in the array.
- The Deque stores indexes, not the actual values.

For example, when `i = 0`, the current element is `nums[0] = 1`.

When `i = 1`, the current element is `nums[1] = 3`.

The Deque helps us keep track of possible maximum values.

## 2. Remove indexes outside the window

java
```
while (!deque.isEmpty()
        && deque.peekFirst() <= i - k) {

    deque.removeFirst();
}
```

Purpose: Remove indexes that no longer belong to the current window.

Let's understand each part:

- `!deque.isEmpty()` checks that the Deque is not empty.
- `deque.peekFirst()` returns the index at the front of the Deque.
- `i - k` is the last index that has become too old for the current window.
- `deque.removeFirst()` removes that outdated index.

### Example: `i = 3`, `k = 3`

The current window is:

text
```
Index:   1   2   3
Value:   3  -1  -3
```

The index `0` is outside this window.

The condition becomes:

java
```
deque.peekFirst() <= 3 - 3
deque.peekFirst() <= 0
```

If the front index is `0`, it is removed.

Why? Because the element at index `0` no longer belongs to the current window.

## 3. Remove smaller values from the back

java
```
while (!deque.isEmpty()
        && nums[deque.peekLast()] <= nums[i]) {

    deque.removeLast();
}
```

This is the most important part of the algorithm.

Purpose: Remove elements that cannot possibly be the maximum of the current or any future window containing the current element.

Let's break it down:

- `deque.peekLast()` returns the last index in the Deque.
- `nums[deque.peekLast()]` gets the value at that index.
- `nums[i]` is the current value.
- If the last value is less than or equal to the current value, remove it.

### Example: `i = 1`

Array:

text
```
Index:   0   1
Value:   1   3
```

Initially, the Deque contains:

text
```
[0]  → value 1
```

Now the current value is `3`.

The condition checks:

java
```
nums[deque.peekLast()] <= nums[i]

nums[0] <= nums[1]

1 <= 3   // true
```

Therefore:

java
```
deque.removeLast();
```

Index `0` is removed, and then index `1` is added.

The Deque becomes:

text
```
[1]  → value 3
```

Why remove `1`?

Because `3` is greater than `1` and comes after it. As long as both elements are in a window, `1` cannot be the maximum because `3` is also present.

So we don't need to keep `1`.

The same logic applies to multiple smaller elements, which is why we use `while` instead of `if`.

## 4. Add the current index

java
```
deque.addLast(i);
```

After removing outdated indexes and smaller values, add the current index to the back of the Deque.

For example, if `i = 2` and `nums[i] = -1`, the Deque might contain:

text
```
Indexes: [1, 2]
Values:  [3, -1]
```

Notice that the values represented by the Deque are in decreasing order:

text
```
3 >= -1
```

This is the key property that makes the algorithm efficient.

The front of the Deque always contains the index of the largest value among the elements currently stored.

## 5. Check whether the first complete window is ready

java
```
if (i >= k - 1) {
```

A window of size `k` needs `k` elements before we can calculate its maximum.

For `k = 3`, the first complete window ends at index `2`.

text
```
Index:   0   1   2
Value:   1   3  -1
```

Since:

java
```
i >= k - 1
2 >= 3 - 1
2 >= 2  // true
```

We can now calculate the maximum.

Before index `2`, there aren't enough elements to form a complete window, so we don't store a result yet.

## 6. Store the maximum in the result array

java
```
result[i - k + 1] =
        nums[deque.peekFirst()];
```

This line does two things.

Part A: Find the maximum

java
```
nums[deque.peekFirst()]
```

The front of the Deque holds the index of the maximum value.

For the first window:

text
```
Window: [1, 3, -1]
Deque indexes: [1, 2]
Deque values:  [3, -1]
```

The front index is `1`, so:

java
```
nums[1] = 3
```

The maximum is `3`.

Part B: Decide where to store the maximum

java
```
result[i - k + 1]
```

When `i = 2` and `k = 3`:

java
```
result[2 - 3 + 1]
result[0]
```

So we store `3` at `result[0]`.

The first result is:

text
```
result = [3, ...]
```

The expression `i - k + 1` calculates the position of the current window's maximum in the result array.

## 7. Let's trace the entire loop

For `nums = [1, 3, -1, -3, 5, 3, 6, 7]` and `k = 3`:

Deque values are shown in front-to-back order. The Deque actually stores their indexes.

| `i` | Current value | Deque values after updates | Maximum recorded |
| --- | --- | --- | --- |
| 0 | 1 | `[1]` | Not yet |
| 1 | 3 | `[3]` | Not yet |
| 2 | -1 | `[3, -1]` | 3 |
| 3 | -3 | `[3, -1, -3]` | 3 |
| 4 | 5 | `[5]` | 5 |
| 5 | 3 | `[5, 3]` | 5 |
| 6 | 6 | `[6]` | 6 |
| 7 | 7 | `[7]` | 7 |

The maximum recorded at each step is based on the most recent window of size `3`.

Therefore:

text
```
Window 1: [1, 3, -1]   → 3
Window 2: [3, -1, -3]  → 3
Window 3: [-1, -3, 5]  → 5
Window 4: [-3, 5, 3]   → 5
Window 5: [5, 3, 6]    → 6
Window 6: [3, 6, 7]    → 7
```

Final result:

java
```
[3, 3, 5, 5, 6, 7]
```

## Remember these three rules

- Remove from the front: If an index is outside the current window, remove it.
- Remove from the back: If a value is less than or equal to the current value, remove it because the current value is at least as large and appears later.
- Read from the front: The front index identifies the maximum value for the current window.

The algorithm runs in $O(n)$ time, because each index is added to and removed from the Deque at most once. It uses $O(k)$ auxiliary space for the Deque in the usual sliding-window analysis.










