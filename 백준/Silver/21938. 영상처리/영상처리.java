

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;

    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i< N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int color1 = Integer.parseInt(st.nextToken());
                int color2 = Integer.parseInt(st.nextToken());
                int color3 = Integer.parseInt(st.nextToken());

                map[i][j] = (color1+color2+color3)/3;
            }
        }

        T = Integer.parseInt(br.readLine());

        int count =0;




        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]>=T&&!visited[i][j]){

                    dfs(j,i);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int x, int y){
        visited[y][x]=true;
        for (int i = 0; i < 4; i++) {
            int next_x = x+dx[i];
            int next_y = y+dy[i];

            if(next_x>=0&&next_y>=0&&next_y<N&&next_x<M&&map[next_y][next_x]>=T&&!visited[next_y][next_x]){
                dfs(next_x,next_y);
            }
        }

    }
}
