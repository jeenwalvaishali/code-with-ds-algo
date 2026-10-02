package collection.arraylist;

import java.util.ArrayList;
import java.util.List;

/*Important operations
add()       → O(1) amortized
get(index)  → O(1)
set()       → O(1)
remove()    → O(n)
contains()  → O(n)*/

/*Use when you need an ordered, resizable list and frequently access elements by index.*/

public class ArrayListExample {

    public static void main(String[] args){

        List<String> stocks = new ArrayList<>();

        //Add
        stocks.add("AMZN");
        stocks.add("AAPL");
        stocks.add("GOOG");


        //Access
        System.out.println(stocks.get(0));

        //Update
        stocks.set(1, "MSFT");

        //Remove
        stocks.remove("GOOG");

        //Size
        System.out.println(stocks.size());

        //Check
        System.out.println(stocks.contains("AAPL"));

        //Iterate
        for(String stock: stocks){
                System.out.println(stock);
            }
    }
}
