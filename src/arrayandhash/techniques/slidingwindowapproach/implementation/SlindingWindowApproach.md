This is the **Sliding Window** technique for finding the **maximum sum of any contiguous subarray of size `k`**.

For your example:

```
arr = {2, 3, 6, 1, 5, 4}
k = 3
```

We want to find the 3 consecutive numbers whose sum is largest.

## 1\. First window

The first `k = 3` elements are:

```
[2, 3, 6]  1  5  4
```

Calculate their sum:

```
2 + 3 + 6 = 11
```

So:

```
windowSum = 11;
maxSum = 11;
```

---

## 2\. Slide the window one position

Now we move the window one step to the right:

```
2  [3, 6, 1]  5  4
```

Instead of calculating:

```
3 + 6 + 1 = 10
```

from scratch, we use:

```
windowSum += arr[i] - arr[i-k];
```

At this point:

```
i = 3
```

So:

```
arr[i]   = arr[3] = 1
arr[i-k] = arr[0] = 2
```

Therefore:

```
windowSum = 11 + 1 - 2
           = 10
```

The window is:

```
[3, 6, 1]
```

Its sum is `10`.

Compare:

```
maxSum = max(11, 10)
       = 11
```

---

## 3\. Slide again

Window moves:

```
2  3  [6, 1, 5]  4
```

We remove `3` and add `5`:

```
windowSum = 10 + 5 - 3
           = 12
```

So:

```
[6, 1, 5] = 12
```

Update:

```
maxSum = max(11, 12)
       = 12
```

---

## 4\. Slide one more time

Window:

```
2  3  6  [1, 5, 4]
```

Remove `6`, add `4`:

```
windowSum = 12 + 4 - 6
           = 10
```

So:

```
[1, 5, 4] = 10
```

And:

```
maxSum = max(12, 10)
       = 12
```

Therefore the answer is:

```
12
```

The maximum-sum subarray is:

```
[6, 1, 5]
```

---

## What this line is really doing

The most important line is:

```
windowSum += arr[i] - arr[i-k];
```

Think of it as:

```
new window sum
    =
old window sum
    - number leaving the window
    + number entering the window
```

For example:

```
Old:  [2, 3, 6]  → sum = 11
       ↓
New:     [3, 6, 1] → sum = 10
```

We don't need to add `3 + 6 + 1` again.

We simply do:

```
11 - 2 + 1 = 10
```

That's the key idea behind **Sliding Window**.

## Visual summary

```
Array:  2   3   6   1   5   4
        └───────┘
        2+3+6 = 11
        max = 11

            └───────┘
            3+6+1 = 10
            max = 11

                └───────┘
                6+1+5 = 12
                max = 12

                    └───────┘
                    1+5+4 = 10
                    max = 12
```

So your program prints:

```
12
```

### Why Sliding Window is useful

A brute-force approach would recalculate every 3-element sum each time.

Sliding Window avoids that repeated work. For each move, it only does:

```
remove 1 element
add 1 element
```

So the algorithm runs in **O(n)** time instead of **O(n × k)**.

One small caveat: your code assumes `k` is valid (`1 <= k <= arr.length`) and works as written for non-negative arrays; 
if the array can contain all negative numbers, `maxSum = 0` would be problematic only if you changed the initialization logic—not in your current code, 
since you immediately set `maxSum = windowSum`.