

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] map;
    public static boolean[] visited;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bfs(0,0));


    }

    public static int bfs(int now,int count){
        Queue<int[]> queue = new LinkedList<>();
        visited[now]=true;

        queue.add(new int[]{now,count});

        while (!queue.isEmpty()){
            int now_cx[] = queue.poll();
            int now_x = now_cx[0];
            int now_count = now_cx[1];
            if(now_x>N){
                return -1;
            }
            if(now_x==N-1){
                return now_count;
            }
            for (int i = 1; i <= map[now_x]; i++) {
                int next_x = now_x+i;

                if(next_x<N&&!visited[next_x]){
                    visited[next_x]=true;
                    queue.add(new int[]{next_x,now_count+1});
                }
            }

        }
        return -1;

    }
}
