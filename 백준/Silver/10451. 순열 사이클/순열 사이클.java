

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TESTCASE = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < TESTCASE; testCase++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            visited = new boolean[N];
            int count = 0;
            st = new StringTokenizer(br.readLine());

            map = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                map[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken())-1;
                map[i].add(arr[i]);
            }

            for (int i = 0; i < N; i++) {
                if(!visited[i]){
                    count++;
                    dfs(i);

                }
            }

            sb.append(count).append('\n');

        }
        System.out.println(sb);

    }
    static boolean[] visited;
    static ArrayList<Integer>[] map;
    static int[] arr;
    public static void dfs(int index){
        visited[index]= true;
        for(int next : map[index]){
            if(visited[next]){
                continue;
            }
            dfs(next);
        }
    }
}
