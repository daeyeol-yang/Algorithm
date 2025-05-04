

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] visited;
    static ArrayList<Integer>[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken())-1;

        map = new ArrayList[N];
        visited = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            map[s].add(e);
            map[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(map[i], Comparator.reverseOrder());
        }

        visited[start] = order;
        dfs(start);

        for(int node : visited){
            sb.append(node).append('\n');
        }
        System.out.println(sb);
    }
    static int order=1;
    static void dfs(int node){
        visited[node] = order;

        for(int nowNode : map[node]){

            if(visited[nowNode]==0){

                visited[nowNode] = ++order;
                dfs(nowNode);
            }
        }


    }
}
