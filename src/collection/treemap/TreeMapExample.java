package collection.treemap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        Map<Integer, String> employees = new TreeMap<>();

        employees.put(103, "Charlie");
        employees.put(101, "Alex");
        employees.put(102, "Bob");

        System.out.println(employees);
    }
}
