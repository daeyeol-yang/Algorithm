

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean[][] map;

    public static boolean[][] visited;

    public static int N,M;

    public static int[] dx={0,0,1,-1};
    public static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int count =0;

            map = new boolean[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());

                map[y][x]= true;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[j][k]&&!visited[j][k]){
                        dfs(k,j);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);

    }

    public static void dfs(int x, int y){
        visited[y][x] =true;

        for (int i = 0; i < 4; i++) {
            int next_x = x+dx[i];
            int next_y = y+dy[i];

            if(next_x>=0&&next_x<M&&next_y>=0&&next_y<N&&!visited[next_y][next_x]&&map[next_y][next_x]){
                dfs(next_x,next_y);
            }
        }




    }
}
