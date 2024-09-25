

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] visited;
    public static ArrayList<Integer>[] arrayLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[N];
        visited = new int[N];
        for (int i = 0; i < N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arrayLists[A-1].add(B-1);
            arrayLists[B-1].add(A-1);
        }

        bfs(0);

        int max =0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max,visited[i]);
        }

        int number =0;
        int count =0;
        for (int i = N-1; i >=0  ; i--) {
            if(max==visited[i]){
                number=i;
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(number+1).append(" ").append(max-1).append(" ").append(count);



        System.out.println(sb);


    }

    public static void bfs(int N){
        Queue<Integer> queue = new LinkedList();
        queue.add(N);
        visited[N] = 1;
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int next : arrayLists[now]){
                if(visited[next]==0){
                    visited[next]=visited[now]+1;
                    queue.add(next);
                }
            }

        }


    }
}
