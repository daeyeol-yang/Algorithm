

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;

    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp.substring(j,j+1));
            }
        }

        for (int i = 0; i < M; i++) {
            if(map[0][i]==0 && !visited[0][i]){
                dfs(i,0);
            }
        }

        if(check()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        

    }

    public static void dfs(int x, int y){
        visited[y][x]=true;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x>=0 && next_y>=0 && next_x< M && next_y<N && !visited[next_y][next_x] && map[next_y][next_x]==0){

                dfs(next_x,next_y);
            }
        }
    }

    public static boolean check(){
        for (int i = 0; i < M; i++) {
            if(visited[N-1][i]){
                return true;
            }
        }
        return false;
    }
}
