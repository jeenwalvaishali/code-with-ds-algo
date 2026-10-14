package collection.questions;

/*Problem
A = [1, 2, 3, 4]
B = [3, 4, 5, 6]

Output:
[3, 4]*/

import java.util.HashSet;
import java.util.Set;

public class FindCommonElements {

    public static Set<Integer> find(int[] a, int[] b){
        Set<Integer> set = new HashSet<>();

        for (int number : a){
            set.add(number);
        }

        Set<Integer>common = new HashSet<>();

        for (int number : b){
            if (set.contains(number)){
                common.add(number);
            }
        }
        return common;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {3, 4, 5, 6};

        System.out.println(find(a,b));
    }
}
