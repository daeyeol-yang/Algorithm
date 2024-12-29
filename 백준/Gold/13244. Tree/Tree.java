

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer>[] arrayLists;

    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < N; test++) {

            int nodeSize = Integer.parseInt(br.readLine());

            arrayLists = new ArrayList[nodeSize];
            visited = new boolean[nodeSize];

            for (int i = 0; i < nodeSize; i++) {
                arrayLists[i] = new ArrayList<>();
            }

            int edgeSize = Integer.parseInt(br.readLine());
            StringTokenizer st;

            for (int i = 0; i < edgeSize; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken())-1;
                int num2 = Integer.parseInt(st.nextToken())-1;

                arrayLists[num1].add(num2);
                arrayLists[num2].add(num1);

            }

            dfs(0);

            if(edgeSize==nodeSize-1 && check()){
                sb.append("tree");
            }else{
                sb.append("graph");
            }

            sb.append('\n');

        }

        System.out.println(sb);
    }

    public static boolean check(){

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    public static void dfs(int node){
        visited[node] = true;
        for(int nextNode : arrayLists[node]){
            if(!visited[nextNode]){
                dfs(nextNode);
            }
        }
    }
}
