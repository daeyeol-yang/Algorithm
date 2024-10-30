

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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


        st = new StringTokenizer(br.readLine());

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        HashMap<Integer,Integer> countHashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            countHashMap.put(num,countHashMap.getOrDefault(num,0)+1);
            if(!hashMap.containsKey(num)){
                hashMap.put(num,i);
            }


        }



        ArrayList<Integer> arrayList = new ArrayList<>(hashMap.keySet());
        StringBuilder sb = new StringBuilder();


        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(countHashMap.get(o2).equals(countHashMap.get(o1))){
                    return  hashMap.get(o1).compareTo(hashMap.get(o2));
                }
                return countHashMap.get(o2).compareTo(countHashMap.get(o1));
            }
        });







        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j <countHashMap.get(arrayList.get(i)); j++) {

                sb.append(arrayList.get(i)).append(" ");
            }
        }

        System.out.println(sb);

    }
}
