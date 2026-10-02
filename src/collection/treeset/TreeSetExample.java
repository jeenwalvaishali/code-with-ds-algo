package collection.treeset;

import java.util.Set;
import java.util.TreeSet;

/*TreeSet
Use when you need:
unique + sorted values

Unlike HashSet, it maintains sorted order.*/

/*Complexity
add()      → O(log n)
remove()   → O(log n)
contains() → O(log n)*/

public class TreeSetExample {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(40);
        set.add(10);
        set.add(20);
        set.add(40);
        set.add(30);

        System.out.println(set);
    }
}
