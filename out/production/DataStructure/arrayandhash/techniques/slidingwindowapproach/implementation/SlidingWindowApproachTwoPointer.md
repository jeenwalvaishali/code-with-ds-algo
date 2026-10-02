This is another **Sliding Window + Two Pointer** problem.

The goal of your method is:

> Find the length of the **longest substring without repeating characters**.

For:

```
String str = "abcabcbb";
```

The answer is `3`, because `"abc"` is the longest substring with no duplicate characters.

---

## 1\. What do `left` and `right` mean?

You have two pointers:

```
int left = 0;
int right = 0;
```

Think of them as defining a **window** inside the string:

```
a b c a b c b b
↑
left/right
```

The `Set<Character>` keeps track of the characters currently inside our window.

Initially:

```
left = 0
right = 0
set = {}
maxLength = 0
```

---

## 2\. `right` moves forward when there is no duplicate

Your main condition is:

```
if (!set.contains(str.charAt(right)))
```

In simple terms:

> "Is the character at `right` already inside my window?"

If **NO**, add it and expand the window.

---

### Step 1: `right = 0`

Character:

```
str.charAt(0) = 'a'
```

Set is empty:

```
{}
```

`a` isn't there, so add it:

```
{a}
```

Window:

```
[a] b c a b c b b
 ↑
 L/R
```

Length:

```
set.size() = 1
```

So:

```
maxLength = 1;
right++;
```

Now:

```
left = 0
right = 1
```

---

### Step 2: `right = 1`

Character:

```
'b'
```

Set:

```
{a}
```

`b` isn't there.

Add it:

```
{a, b}
```

Window:

```
[a b] c a b c b b
 ↑   ↑
 L   R
```

Length:

```
2
```

So:

```
maxLength = 2;
right++;
```

---

### Step 3: `right = 2`

Character:

```
'c'
```

Set:

```
{a, b}
```

`c` isn't there.

Add it:

```
{a, b, c}
```

Window:

```
[a b c] a b c b b
 ↑     ↑
 L     R
```

Length:

```
3
```

So:

```
maxLength = 3;
right++;
```

At this point we have found:

```
"abc"
```

with length `3`.

---

# 3\. Now we encounter a duplicate

`right = 3`

Character:

```
str.charAt(3) = 'a'
```

But our set is:

```
{a, b, c}
```

`a` is already there!

So this condition is false:

```
if (!set.contains(str.charAt(right)))
```

We go into:

```
else {
    set.remove(str.charAt(left));
    left++;
}
```

This is the important part.

We **don't move `right`**.

Instead, we shrink the window from the left.

Current window:

```
[a b c] a b c b b
 ↑     ↑
left  right
```

Remove:

```
'a'
```

Set becomes:

```
{b, c}
```

Then:

```
left++;
```

So:

```
left = 1
right = 3
```

Our window is now:

```
a [b c] a b c b b
  ↑   ↑
 left right
```

---

# 4\. Check `'a'` again

Notice that `right` is **still 3**.

We go through the loop again.

Current character:

```
str.charAt(right) = 'a'
```

Set:

```
{b, c}
```

`a` is no longer there.

So we add it:

```
{b, c, a}
```

Window:

```
a [b c a] b c b b
  ↑     ↑
 left  right
```

Length:

```
3
```

`maxLength` stays:

```
3
```

Then:

```
right++;
```

Now:

```
left = 1
right = 4
```

---

# 5\. Continue

The next character is `'b'`.

But:

```
set = {b, c, a}
```

`b` already exists.

So we remove from the left:

```
a [b c a] b c b b
  ↑
 left
```

Remove `b`:

```
set = {c, a}
```

Move `left`:

```
left = 2
```

We **still don't move `right`**.

Next iteration, `'b'` is no longer in the set.

Add it:

```
set = {c, a, b}
```

Window:

```
a b [c a b] c b b
    ↑     ↑
   left  right
```

Length is again `3`.

---

## 6\. The whole process

Here's the important part summarized:

| Step | `left` | `right` | Character | Action | Window | Length |
| --- | --- | --- | --- | --- | --- | --- |
| 1 | 0 | 0 | `a` | Add | `abc...` | 1 |
| 2 | 0 | 1 | `b` | Add | `ab...` | 2 |
| 3 | 0 | 2 | `c` | Add | `abc...` | 3 |
| 4 | 0 | 3 | `a` | Duplicate → remove `a` | `bc...` | 3 |
| 5 | 1 | 3 | `a` | Add | `bca...` | 3 |
| 6 | 1 | 4 | `b` | Duplicate → remove `b` | `ca...` | 3 |
| 7 | 2 | 4 | `b` | Add | `cab...` | 3 |
| ... | ... | ... | ... | ... | ... | 3 |

Eventually the algorithm reaches the end and returns:

```
3
```

---

# The key idea

There are **two pointers**:

```
left  → controls where the window starts
right → controls where the window ends
```

### When the character is new:

```
set.add(str.charAt(right));
right++;
```

We **expand** the window.

```
[a b c]
↑     ↑
L     R
```

### When the character is a duplicate:

```
set.remove(str.charAt(left));
left++;
```

We **shrink** the window.

```
[a b c] a
↑
L

remove a

a [b c] a
  ↑
  L
```

We keep shrinking until the duplicate is gone.

---

## Why don't we reset the whole window?

This is the clever part.

Suppose we have:

```
abcabcbb
```

When we see the second `a`:

```
[a b c] a
```

A beginner might think:

> "Start over from the second `a`."

But we don't need to.

We simply remove characters from the left:

```
[a b c] a
 ↑

[b c] a
 ↑

[b c a]
```

We preserve as much of the existing window as possible.

That's why the algorithm is efficient.

---

## Think of it like a physical window 🪟

Imagine `left` and `right` are the sides of a window:

```
a b c a b c b b
|-----|
left  right
```

The rule is:

**No duplicates inside the window.**

When you encounter a duplicate:

```
a b c [a]
|-----|
```

you move the **left side forward** until the duplicate disappears.

When there is no duplicate, you move the **right side forward** to make the window bigger.

Finally, `maxLength` remembers the biggest valid window we've seen.

For `"abcabcbb"`:

```
abc
bca
cab
```

are some of the longest valid windows, all having length:

```
3
```

So:

```
System.out.println(maxSum);
```

prints:

```
3
```

### One sentence to remember

> **Right expands the window; when a duplicate appears, left shrinks the window until it's valid again.**