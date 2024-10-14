

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if(s.length()<size){
                continue;
            }
            hashMap.put(s,hashMap.getOrDefault(s,0)+1);

        }


        ArrayList<Map.Entry<String,Integer>> arrayList = new ArrayList<>(hashMap.entrySet());

        Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue())){
                    if(o1.getKey().length()==o2.getKey().length()){

                        return o1.getKey().compareTo(o2.getKey());
                    }else{
                        return o2.getKey().length()-o1.getKey().length();

                    }
                }else{
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i).getKey()).append('\n');
        }

        System.out.println(sb);
    }
}
