package collection.hashset;

import java.util.HashSet;

/*add()       → O(1) average
remove()    → O(1) average
contains()  → O(1) average*/

/*Use when you need unique values and fast lookup.*/

public class HashSetExample {

    public static void main(String[] args){
        HashSet<String> users = new HashSet<>();

        //add
        users.add("Alice");
        users.add("Bob");
        users.add("Charlie");

        //Duplicate Ignored
        users.add("Alice");

        System.out.println(users);

        //Fast Lookup
        System.out.println(users.contains("Bob"));

        //Remove
        users.remove("Alice");

        System.out.println(users);

        System.out.println("Size: " + users.size());

    }
}
