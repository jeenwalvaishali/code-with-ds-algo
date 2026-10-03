This is a common Java pattern for **grouping multiple values under the same key**.

### Pattern — Grouping

```
Map<String, List<String>> map = new HashMap<>();

map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);

```

### What we're trying to build

Suppose you have:

```
Map<String, List<String>> map = new HashMap<>();
```

The map might eventually look like:

```
"fruit"  → ["apple", "banana", "orange"]
"color"  → ["red", "blue"]
"animal" → ["cat", "dog"]
```

So:

- The **key** is a `String`
- The **value** is a `List<String>`

---

### The interesting part

```
map.computeIfAbsent(
    key,
    k -> new ArrayList<>()
).add(value);
```

Let's break it down.

#### 1\. `computeIfAbsent`

`computeIfAbsent` basically says:

> "Get the value for this key. If the key doesn't exist, create a value for it."

For example:

```
map.computeIfAbsent("fruit", k -> new ArrayList<>());
```

If `"fruit"` doesn't exist, Java creates:

```
"fruit" → []
```

The `k -> new ArrayList<>()` is a **lambda** that tells Java what to create when the key is missing.

---

#### 2. It returns the list

This is the really useful part.

After:

```
map.computeIfAbsent("fruit", k -> new ArrayList<>())
```

the expression itself evaluates to:

```
[]
```

So you can immediately call:

```
.add(value)
```

That's why this works:

```
map.computeIfAbsent(key, k -> new ArrayList<>())
   .add(value);
```

It's essentially:

```
List<String> list = map.computeIfAbsent(
    key,
    k -> new ArrayList<>()
);

list.add(value);
```

---

### Example

Imagine:

```
String key = "fruit";
String value = "apple";
```

Initially:

```
map = {}
```

Run:

```
map.computeIfAbsent(
    key,
    k -> new ArrayList<>()
).add(value);
```

Now:

```
map = {
    "fruit" → ["apple"]
}
```

Then suppose:

```
key = "fruit";
value = "banana";
```

Run it again.

This time `"fruit"` **already exists**, so Java does **not** create a new `ArrayList`.

It retrieves the existing list:

```
["apple"]
```

and then `.add("banana")`:

```
map = {
    "fruit" → ["apple", "banana"]
}
```

---

### Why is this called "Grouping"?

Because you're effectively saying:

> **For each key, collect all the values associated with that key into a list.**

For example, given:

```
fruit  apple
fruit  banana
color  red
fruit  orange
color  blue
```

you get:

```
fruit → [apple, banana, orange]
color → [red, blue]
```

### Without `computeIfAbsent`

The longer way would be:

```
if (!map.containsKey(key)) {
    map.put(key, new ArrayList<>());
}

map.get(key).add(value);
```

`computeIfAbsent` compresses those operations into:

```
map.computeIfAbsent(key, k -> new ArrayList<>())
   .add(value);
```

So the mental model I'd use is:

> **"Give me the list for this key; if there isn't one, create an empty list. Then add my value to that list."**

That one sentence explains the entire pattern.