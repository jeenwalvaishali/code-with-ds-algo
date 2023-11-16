package arrayandhash.questions;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hashmap = new HashMap<>();

        for (int i = 0; i<strs.length; i++){
            String str = strs[i];
            char[] strToArray = str.toCharArray();
            Arrays.sort(strToArray);
            String arrToString = String.valueOf(strToArray);

            if(!hashmap.containsKey(arrToString)){
                hashmap.put(arrToString, new ArrayList<>());
            }

            hashmap.get(arrToString).add(str);
        }

        return new ArrayList<>(hashmap.values());
    }

    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>>map = groupAnagrams(strs);
        System.out.println(map);
    }
}
