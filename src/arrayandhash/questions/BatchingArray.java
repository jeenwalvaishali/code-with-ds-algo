package arrayandhash.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BatchingArray {
    public static void main(String[] args)
    {
        int n = 4;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<21;i++){
            list.add(i);
        }
        HashMap<Integer,ArrayList<Integer>> batchMap = createBatch(3, list);
        for (Map.Entry<Integer, ArrayList<Integer>> set : batchMap.entrySet()) {
            int id = set.getKey();
            ArrayList<Integer> element = set.getValue();
            System.out.println("Batch ID : "+id);
            for (int i=0; i<element.size();i++){
                System.out.println(element.get(i));
            }
        }
    }

    public static HashMap<Integer,ArrayList<Integer>> createBatch(int batchSize, ArrayList<Integer> list){
        HashMap<Integer,ArrayList<Integer>> batchMap = new HashMap<>();
        int batchId = 1;
        int listSize = list.size();
        if(listSize<batchSize)
        {
            batchMap.put(batchId,list);
            return batchMap;
        }else{
            ArrayList<Integer> batch = new ArrayList<>();
            batchMap.put(1,batch);
            int startIndex = 0;
            int count = batchSize;
            for(int i=0;i<listSize;i++)
            {
                while (i<listSize && startIndex < count){
                    batch.add(list.get(i));
                    i++;
                    startIndex++;
                }
                batchMap.put(batchId,batch);
                if(i<listSize){
                    i--;
                    batch = new ArrayList<>();
                    batchId++;
                    count = count + batchSize;
                }
            }
        }
        return batchMap;
    }
}
