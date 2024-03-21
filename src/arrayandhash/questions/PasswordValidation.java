package arrayandhash.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PasswordValidation {

    public static List<String> getRegistrationStatus(List<String> passwords,
        int k) {

        Map<String, Integer> map = new HashMap<>();
        List<String> reList = new ArrayList<>();

        for (int i=0; i<passwords.size()- 1; i++){
            if(!map.containsKey(passwords.get(i))){
                map.put(passwords.get(i), map.getOrDefault(passwords.get(i), 0)+1);
            }

            if (map.get(passwords.get(i)) > k){
                reList.add("REJECT");
            }else {
                reList.add("ACCEPT");
            }
        }

        return reList;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("dddr");
    }

}
