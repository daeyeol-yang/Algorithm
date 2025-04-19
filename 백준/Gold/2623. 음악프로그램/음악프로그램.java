

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] degree = new int[N];
        List<Integer>[] map = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                map[i].add(Integer.parseInt(st.nextToken())-1);
            }

        }
        

        List<Integer>[] map1 = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            map1[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            for (int j = 1; j < map[i].size(); j++) {
                int after = map[i].get(j);
                int prev = map[i].get(j-1);

                if(!map1[prev].contains(after)){
                    map1[prev].add(after);
                }

            }
        }

        //degree 찾아주기

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < map1[i].size(); j++) {
                degree[map1[i].get(j)]++;
            }
        }

        List<Integer> orderList = new ArrayList<>();

        Queue<Integer> queue = new ArrayDeque<>();


        for (int i = 0; i < N; i++) {
            if(degree[i]==0){
                queue.add(i);
                orderList.add(i);
            }
        }

        //위상정렬!!
        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int next :map1[now]){
                if(--degree[next]==0){
                    queue.add(next);
                    orderList.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(orderList.size()!=N){
            sb.append(0);
        }else{
            for(int num : orderList){
                sb.append(num+1).append('\n');
            }
        }

        System.out.println(sb);

    }
}
