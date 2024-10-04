

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N,M;

    public static char[][] map1;

    public static boolean[][] visited1;

    public static int[] dx={0,0,1,-1};
    public static int[] dy={1,-1,0,0};

    public static char change;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map1 = new char[N][M];
        char[][] map2 = new char[N][M];

        visited1 = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map1[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map2[i][j] = temp.charAt(j);
            }
        }

        boolean impossible=false;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char beforeChange = map1[i][j];
                change = map2[i][j];
                if(beforeChange!=change&&!visited1[i][j]){
                    dfs(j,i,beforeChange);
                }

                if(map1[i][j]!=change){
                    impossible=true;
                    break;
                }
            }
            if(impossible){
                break;
            }

        }



        if(impossible){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }


    }


    public static void dfs(int x,int y,char c){
        visited1[y][x] =true;
        map1[y][x] = change;

        for (int i = 0; i < 4; i++) {
            int next_x  = x+dx[i];
            int next_y = y+dy[i];

            if(next_x>=0&&next_y>=0&&next_x<M&&next_y<N&&!visited1[next_y][next_x]&&map1[next_y][next_x]==c){
                dfs(next_x,next_y,c);
            }

        }

    }
}
