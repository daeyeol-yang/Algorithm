

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int target = Integer.parseInt(st.nextToken());
        int person = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < person; i++) {
            
            String num = br.readLine();
            map.put(num,i);
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String ,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o1.getValue() , o2.getValue());
            }
        });

        for (int i = 0; i < target && i<list.size(); i++) {
            sb.append(list.get(i).getKey()).append('\n');
        }

        System.out.println(sb);
    }
}
