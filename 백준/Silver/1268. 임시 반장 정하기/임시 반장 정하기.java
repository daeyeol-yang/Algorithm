

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] map = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            hashMap.put(i+1,new HashSet<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {

                int hak=map[i][j];
                for (int k = 0; k < N; k++) {
                    if(hak == map[k][j]){
                        HashSet<Integer> tempHashSet = hashMap.get(i+1);
                        tempHashSet.add(k+1);
                        hashMap.put(i+1,tempHashSet);
                    }
                }

            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>(hashMap.keySet());

        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(hashMap.get(o1).size()==hashMap.get(o2).size()){
                    return Integer.compare(o1,o2);
                }else{
                    return Integer.compare(hashMap.get(o2).size(),hashMap.get(o1).size());
                }
            }
        });

        System.out.println(arrayList.get(0));


    }
}
