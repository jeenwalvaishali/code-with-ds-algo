package collection.hashMap;

import java.util.HashMap;
import java.util.Map;

/*This is probably the most important collection for your interviews.

Use it when you need:

key → value
Examples:

userId → User
stock  → prices
word   → frequency
taskId → Task
URL    → original URL*/

/*Complexity
put()       → O(1) average
get()       → O(1) average
remove()    → O(1) average
containsKey → O(1) average*/

public class HashMapExample {

    public static void main(String[] args){

        HashMap<String, Double> stocksPrices = new HashMap<>();

        //add
        stocksPrices.put("AMZN", 200.0);
        stocksPrices.put("APPL", 150.0);
        stocksPrices.put("GOOG", 180.0);

        //get
        System.out.println(stocksPrices.get("AMZN"));

        //check
        System.out.println(stocksPrices.containsKey("GOOG"));

        //Update
        stocksPrices.put("AMZN", 250.0);

        //Remove
        stocksPrices.remove("APPL");

        //Size
        System.out.println(stocksPrices.size());

        //Iterate
        for(Map.Entry<String, Double> entry : stocksPrices.entrySet()){
            System.out.println("Key:  " + entry.getKey() + "  Value:  " + entry.getValue());
        }

    }
}
