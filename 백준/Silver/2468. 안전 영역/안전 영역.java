

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] visited;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static int N;

    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int maxRain =0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxRain = Math.max(maxRain,map[i][j]);
            }
        }

        int[] safeCount = new int[maxRain];


        for (int rain = 0; rain < maxRain ; rain++) {
            visited = new boolean[N][N];
            int count =0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]>rain&&!visited[i][j]){
                        dfs(j,i,rain);
                        count++;
                    }
                }
            }
            safeCount[rain] = count;
        }

        Arrays.sort(safeCount);

        System.out.println(safeCount[maxRain-1]);
    }

    public static void dfs(int x, int y, int rain){
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int next_x = x+dx[i];
            int next_y = y+dy[i];

            if(next_x>=0&&next_x<N&&next_y>=0&&next_y<N&&!visited[next_y][next_x]&&map[next_y][next_x]>rain){
                dfs(next_x,next_y,rain);
            }
        }

    }
}
