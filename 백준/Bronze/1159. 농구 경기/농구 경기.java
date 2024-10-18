import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            String sung = temp.substring(0,1);
            map.put(sung,map.getOrDefault(sung,0)+1);

        }

        ArrayList<Map.Entry<String,Integer>> arrayList = new ArrayList<>(map.entrySet());
        ArrayList<String> arrayList1 = new ArrayList<>();
        for(Map.Entry<String,Integer> map1: arrayList){
            if(map1.getValue()>=5){
                arrayList1.add(map1.getKey());
            }

        }
        Collections.sort(arrayList1);
        StringBuilder sb = new StringBuilder();
        if(arrayList1.size()==0){
            System.out.println("PREDAJA");

        }else{

            for (int i = 0; i < arrayList1.size(); i++) {
                sb.append(arrayList1.get(i));
            }
            System.out.println(sb);
        }
    }
}
