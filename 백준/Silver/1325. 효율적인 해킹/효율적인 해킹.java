
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] visited;
    public  static ArrayList<Integer>[] map;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }
        arr = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            int num_related = Integer.parseInt(st.nextToken())-1;

            map[num].add(num_related);
        }

        for (int i = 0; i < map.length; i++) {
            visited = new boolean[N];
            dfs(i);
        }

        int max =0;
        for (int i = 0; i < N; i++) {
            max = Math.max(arr[i],max);
        }

        StringBuilder sb  = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if(arr[i]==max){
                sb.append(i+1).append(" ");
            }
        }


        System.out.println(sb);
    }

    public static void dfs(int n){
        visited[n]=true;
        for (int i : map[n]){
            if(!visited[i]){

                arr[i]++;
                dfs(i);


            }
        }


    }
}
