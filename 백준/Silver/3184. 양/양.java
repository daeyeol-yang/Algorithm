

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int ship;
    public static int wolf;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static char[][] map;
    public static boolean[][] visited;

    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N  = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());


        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int sumS =0;
        int sumW =0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]!='#'&&!visited[i][j]){
                    ship=0;
                    wolf=0;
                    dfs(j,i);


                    if(wolf<ship){
                        sumS+=ship;
                    }else{
                        sumW+=wolf;

                    }


                }
            }
        }
        

        StringBuilder sb = new StringBuilder();
        sb.append(sumS).append(" ").append(sumW);

        System.out.println(sb);

    }

    public static void dfs(int x, int y){
        visited[y][x]=true;
        if(map[y][x]=='o'){
            ship++;
        }else if(map[y][x]=='v'){
            wolf++;
        }
        for (int i = 0; i < 4; i++) {

            int next_x = x+dx[i];
            int next_y = y+dy[i];

            if(next_x>=0&&next_y>=0 && next_x < M &&next_y<N &&!visited[next_y][next_x] && map[next_y][next_x]!='#'){


                dfs(next_x,next_y);
            }

        }


    }
}
