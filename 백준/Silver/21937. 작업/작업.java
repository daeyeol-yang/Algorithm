

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer>[] arrayLists;

    public static boolean[] visited;

    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arrayLists[B-1].add(A-1);


        }

        int target = Integer.parseInt(br.readLine());
        dfs(target-1);


        System.out.println(count);
    }

    public static void dfs(int num){
        visited[num]=true;

        for (int i : arrayLists[num]){
            if(!visited[i]){
                count+=1;
                dfs(i);
            }
        }






    }
}
