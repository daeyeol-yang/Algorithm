

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        HashMap<String, Integer> hashMap = new HashMap<>();
        int size=0;

        while ((s= br.readLine())!=null&&!s.isEmpty()){
            hashMap.put(s,hashMap.getOrDefault(s,0)+1);
            size++;
        }

        ArrayList<Map.Entry<String, Integer>> arrayList = new ArrayList<>(hashMap.entrySet());

        Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String,Integer> map : arrayList){
            sb.append(map.getKey()).append(" ").append(String.format("%.4f",(double)map.getValue()*100/size)).append('\n');
        }


        System.out.println(sb);
    }
}
