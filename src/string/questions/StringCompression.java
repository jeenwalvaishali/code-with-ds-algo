package string.questions;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public static void main(String[] args){
        String str = "aabccccbbb";
        String compressedString = stringCompressionMain(str);
        System.out.println(compressedString);

    }

    //aabccccbbb

    public static String stringCompressionMain(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;

        for(int i = 0; i<str.length(); i++) {
            char c = str.charAt(i);

            if((i+1) < str.length() && c == str.charAt(i+1)) {
                count++;
            }else {
                stringBuilder.append(c).append(count);
                count = 1;
            }
        }

        return stringBuilder.toString();
    }

    public static String stringCompression(String str){

        HashMap<Character, Integer> hashMap = new HashMap<>();

       for(int i = 0; i<str.length(); i++){
           char c = str.charAt(i);
           hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
       }

       StringBuilder stringBuilder = new StringBuilder();

       for(Map.Entry<Character, Integer> entry : hashMap.entrySet()){
           stringBuilder.append(entry.getKey());
           stringBuilder.append(entry.getValue());
       }

       return stringBuilder.toString();
    }
}
