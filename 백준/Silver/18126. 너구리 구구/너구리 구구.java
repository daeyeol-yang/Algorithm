
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static int N;

    public static int[][] arr;

    public static boolean[] visited;

    public static long max =0;

    public static ArrayList<Integer>[] arrayLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        visited = new boolean[N];

        arrayLists = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            int C = Integer.parseInt(st.nextToken());

            arrayLists[A].add(B);
            arrayLists[B].add(A);
            arr[A][B]=C;
            arr[B][A]=C;

        }

        dfs(0,0);

        System.out.println(max);
    }

    public static void dfs(int num, long d){

        visited[num] = true;

        max = Math.max(d,max);

        for (int n : arrayLists[num]){

            if(!visited[n]){

                dfs(n,d+arr[num][n]);
            }

        }
    }
}
