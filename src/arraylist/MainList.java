package arraylist;

import java.util.ArrayList;

public class MainList {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<String> list = new ArrayList<>();

        // Add elements to the end of the list
        list.add("Banana");
        list.add("Cherry");

        // Add an element at the beginning of the list
        list.add(0, "Apple");


        // Print the ArrayList
        System.out.println("List after adding elements to the end: " + list);
    }
}
