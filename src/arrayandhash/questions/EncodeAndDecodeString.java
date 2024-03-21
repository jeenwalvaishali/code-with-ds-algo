package arrayandhash.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Please implement encode and decode

Example
Example1

Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"
Example2

Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes"
*/
public class EncodeAndDecodeString {
    public static final String DELIMITER = ";:";

    public static String encodeString(List<String> strings){
        StringBuilder encodedString = new StringBuilder();
        int listSize = strings.size();
//        for (String str : strings){
//            encodedString.append(str).append(DELIMITER);
//        }

        for (int i =0; i<listSize-1; i++){
            encodedString.append(strings.get(i)).append(DELIMITER);
        }

        encodedString.append(strings.get(listSize-1));
        System.out.println(strings.get(listSize-1) + "values");

        return encodedString.toString();
    }

    public static List<String> decodeString(String encodedString){
//        List<String> arrayListOfStrings = new ArrayList<>();
//        String[] strs = encodedString.split(DELIMITER);
//        arrayListOfStrings = Arrays.asList(strs);
//
//        return arrayListOfStrings;

        return new ArrayList<>(Arrays.asList(encodedString.split(DELIMITER)));
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("lint","code","love","you");
        System.out.println("Input: " + input);
        String encodedString = encodeString(input);
        System.out.println("Encoded String: " + encodedString);
        List<String> decodedString = decodeString(encodedString);
        System.out.println("Decoded String: " + decodedString);
    }

}
