

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer>[] arrayLists;
    public static boolean[] visited;
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int test = Integer.parseInt(st.nextToken());


        arrayLists = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine());
            int child = Integer.parseInt(st.nextToken())-1;
            int parent = Integer.parseInt(st.nextToken())-1;

            arrayLists[parent].add(child);
        }

        int maxChild =0;
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            
            visited = new boolean[N];
            arr[i] = dfs(i);
            maxChild = Math.max(maxChild,arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if(arr[i]==maxChild){
                sb.append(i+1).append(" ");
            }
        }

        System.out.println(sb);


    }

//    public static void dfs(int node){
//        visited[node] = true;
//
//        for(int next_node : arrayLists[node]){
//            if(!visited[next_node]){
//                dfs(next_node);
//                count+=1;
//            }
//        }
//
//    }
    public static int dfs(int node){
        visited[node] = true;
        int ret =1;

        for(int next_node : arrayLists[node]){
            if(!visited[next_node]){
                ret+= dfs(next_node);
                
            }
        }
        return ret;

    }
}
