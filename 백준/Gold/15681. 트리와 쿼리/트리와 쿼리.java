

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken())-1;
        int Q  = Integer.parseInt(st.nextToken());


        map = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }


        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            map[end].add(start);
            map[start].add(end);
        }
        StringBuilder sb = new StringBuilder();
        visited = new boolean[N];
        subTree = new int[N];
        Arrays.fill(subTree,1);
        dfs(R);
        //System.out.println(Arrays.toString(subTree));
        for (int i = 0; i < Q; i++) {

            int qeury = Integer.parseInt(br.readLine())-1;
            sb.append(subTree[qeury]).append('\n');
        }
        System.out.println(sb);
    }
    static boolean[] visited;
    static int[] subTree;
    static ArrayList<Integer>[] map;

    public static  void dfs(int node){
        visited[node] = true;
        for(int next : map[node]){
            if(visited[next]){
                continue;
            }
            dfs(next);
            subTree[node] += subTree[next];
        }

    }
}
