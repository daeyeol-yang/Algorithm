

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        set = new HashSet<>();
        sol = new int[M];
        go(0);
        System.out.println(set.size());
    }
    static int M;
    static int N;
    static int[] sol;
    static int[] arr;
    static boolean[] visited;
    static HashSet<String> set;

    public static void go(int index){
        if(index == M){
            StringBuilder sb = new StringBuilder();
            for(int num : sol){
                sb.append(num);
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i]){
                continue;
            }
            sol[index] = arr[i];
            visited[i] = true;
            go(index+1);
            visited[i] = false;
        }

    }
}
