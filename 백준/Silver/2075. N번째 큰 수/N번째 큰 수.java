

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][N];
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                arr[i][j]= Integer.parseInt(st.nextToken());
//                arrayList.add(arr[i][j]);
//            }
//        }
//
//        Collections.sort(arrayList,Collections.reverseOrder());
//
//        System.out.println(arrayList.get(N-1));

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
               queue.add(Integer.parseInt(st.nextToken()));
            }

        }

        for (int i = 0; i < N-1; i++) {
            queue.poll();
        }

        System.out.println(queue.poll());

    }
}
