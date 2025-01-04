

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0],o2[0]);

            }
        });

        ArrayList<int[]> arrayList = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());

            arrayList.add(arr);

        }

        Collections.sort(arrayList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               return Integer.compare(o1[1],o2[1]);
            }
        });


        for (int i = 0; i < N; i++) {
            priorityQueue.add(arrayList.get(i));
            if(priorityQueue.size() > arrayList.get(i)[1]){
                priorityQueue.poll();
            }
        }

        int sol =0;

        while (!priorityQueue.isEmpty()){
            sol += priorityQueue.poll()[0];
        }




        System.out.println(sol);


    }
}
