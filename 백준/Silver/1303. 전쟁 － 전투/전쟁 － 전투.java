
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};

    public static char[][] map;
    public static boolean[][] visited;

    public static int N;
    public static int M;
    public static int scoreW;
    public static int scoreB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map  = new char[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        int sumW=0;
        int sumB=0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='W'&&!visited[i][j]){
                    scoreW=0;
                    dfs(j,i,'W');
                    sumW+=Math.pow(scoreW,2);
                } else if (map[i][j]=='B'&&!visited[i][j]) {
                    scoreB=0;
                    dfs(j,i,'B');
                    sumB+=Math.pow(scoreB,2);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sumW).append(" ").append(sumB);

        System.out.println(sb);
    }

    public static void dfs(int x, int y, char target){
        visited[y][x]=true;

        if(target=='W'){
            scoreW++;
        } else if (target=='B') {
            scoreB++;
        }
        for (int i = 0; i < 4; i++) {
            int next_x = x+dx[i];
            int next_y = y+dy[i];

            if(next_x>=0&&next_y>=0&&next_x<M&&next_y<N&&!visited[next_y][next_x]){
                if(target=='W'){
                    if(map[next_y][next_x]=='W'){
                        dfs(next_x,next_y,target);
                    }
                } else if (target=='B') {
                    if(map[next_y][next_x]=='B'){

                        dfs(next_x,next_y,target);
                    }

                }
            }
        }



    }
}
