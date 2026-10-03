In an interview, don't just type the code silently. **Narrate the design first, then code each piece while explaining why you're doing it.**

Here's a natural way to explain this exact LRU Cache.

## 1\. Start with the approach

You can say:

> "I need an LRU cache, so I need two things: a way to store key-value pairs and a way to track which entry was least recently used. Java's `LinkedHashMap` already provides both. If I create it with `accessOrder = true`, it automatically moves an accessed entry to the end. Then I can override `removeEldestEntry` to remove the least recently used entry when the capacity is exceeded."

That's your **core explanation**.

---

## 2\. Start coding the class

Type:

```
import java.util.*;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
```

Explain:

> "I'm making this generic so the cache can work with any key and value types. I'm extending `LinkedHashMap` because it already maintains ordering."

Then:

```
private final int capacity;
```

Say:

> "I need to remember the maximum number of entries the cache is allowed to hold."

---

## 3\. Explain the constructor carefully

Code:

```
public LRUCache(int capacity) {
    super(capacity, 0.75f, true);
    this.capacity = capacity;
}
```

This is probably the **most important line to explain**.

Say:

> "The `LinkedHashMap` constructor takes initial capacity, load factor, and an `accessOrder` flag. I'm passing `true` for access order. This means the map is ordered from least recently accessed to most recently accessed."

Then give a tiny example:

```
put(1,A)
put(2,B)

1 → 2
```

Then:

```
get(1)

2 → 1
```

Say:

> "Because key 1 was accessed, it moves to the end. Therefore key 2 is now the least recently used."

That demonstrates that you understand the mechanism rather than memorizing the code.

---

## 4\. Explain `removeEldestEntry`

Then write:

```
@Override
protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() > capacity;
}
```

Say:

> "Whenever I insert an entry, `LinkedHashMap` checks this method. If the size is greater than the capacity, returning `true` tells it to remove the eldest entry."

Then make the connection:

> "Because I enabled access order, the eldest entry here is the least recently used entry."

That's the key insight.

---

# 5\. Walk through an example while coding

Now show:

```
LRUCache<Integer, String> cache = new LRUCache<>(2);

cache.put(1, "A");
cache.put(2, "B");
```

Say:

> "The capacity is 2. After these two puts, the order is 1, then 2. So 1 is the least recently used."

Draw:

```
1=A → 2=B
LRU     MRU
```

Then:

```
cache.get(1);
```

Explain:

> "Now I access key 1. Since this is an access-ordered `LinkedHashMap`, key 1 moves to the end."

Draw:

```
2=B → 1=A
LRU     MRU
```

Then:

```
cache.put(3, "C");
```

Say:

> "Now the cache temporarily has three entries, which exceeds the capacity of two. `removeEldestEntry` returns true, so the eldest entry—key 2—is removed."

Final:

```
1=A → 3=C
```

Therefore:

```
System.out.println(cache);
```

outputs:

```
{1=A, 3=C}
```

---

# 6\. The interview explanation in one continuous answer

If the interviewer says **"Explain your solution"**, you can say this:

> "I'll implement the LRU cache using `LinkedHashMap`. An LRU cache needs to maintain entries based on their recent usage. `LinkedHashMap` supports access-ordering, so I'll pass `true` as the third constructor argument. That means whenever I access an entry using `get`, that entry moves to the end of the linked list, making the first entry the least recently used.
>
>  I'll also store the maximum capacity. Then I'll override `removeEldestEntry`. Whenever an insertion causes the size to exceed the capacity, this method returns true, which causes Java to remove the eldest entry. Since I'm using access order, that eldest entry is the least recently used one.
>
>  So both `get` and `put` are handled by `LinkedHashMap`, and the cache automatically evicts the least recently used entry."

That's a **very solid interview explanation**.

---

## 7\. If they ask "What's the time complexity?"

Say:

> "`get` and `put` are O(1) average time because `LinkedHashMap` is backed by a hash table, with the linked list maintaining the ordering. Removing the eldest entry is also O(1). Space complexity is O(capacity)."

So:

| Operation | Complexity |
| --- | --- |
| `get()` | O(1) average |
| `put()` | O(1) average |
| Remove LRU | O(1) |
| Space | O(capacity) |

---

## 8\. One important interview trap

The interviewer may ask:

**"Why can't you just use `HashMap`?"**

Good answer:

> "`HashMap` gives me O(1) lookup, but it doesn't maintain the order of accesses. For an LRU cache I need both fast lookup and ordering by recent usage. `LinkedHashMap` gives me both."

And if they ask:

**"Why is `true` important?"**

Say:

> "`true` enables access-order rather than insertion-order. Without it, calling `get(1)` would not move key 1 to the end, so the map wouldn't correctly represent least-recently-used order."

---

### The mental model to remember

Don't memorize the entire code. Remember these **3 ideas**:

```
LinkedHashMap
     ↓
accessOrder = true
     ↓
eldest = least recently used
     ↓
removeEldestEntry when size > capacity
```

If you can explain those four steps clearly, you can reconstruct the code during the interview instead of trying to remember it word-for-word.