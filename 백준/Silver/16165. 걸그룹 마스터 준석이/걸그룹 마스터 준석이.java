

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sol = Integer.parseInt(st.nextToken());
        int quiz = Integer.parseInt(st.nextToken());

        HashMap<String, ArrayList<String> > hashMap = new HashMap<>();
        HashMap<String, String> hashMap1 = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sol; i++) {
            String group = br.readLine();

            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                String name = br.readLine();

                if(hashMap.get(group)!=null){
                   ArrayList<String> temp = hashMap.get(group);
                   temp.add(name);
                   hashMap.put(group, temp);

                }else{
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(name);
                    hashMap.put(group, temp);
                }


                hashMap1.put(name,group);

            }


        }

        for (int i = 0; i < quiz; i++) {
            String quiz1 = br.readLine();
            int sol1 = Integer.parseInt(br.readLine());

            if(sol1==0){

                ArrayList<String> arrayList = hashMap.get(quiz1);
                Collections.sort(arrayList);
                for(String s : arrayList){

                    sb.append(s).append('\n');

                }
                
            }else{
                sb.append(hashMap1.get(quiz1)).append('\n');
            }


        }

        System.out.println(sb);


    }
}
