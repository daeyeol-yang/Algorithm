

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N,M;

    public static boolean[][] map;

    public static int[][] visited;

    public static int[] dx={0,0,1,-1};
    public static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                if(temp.charAt(j)=='L'){
                    map[i][j] = true;
                }
            }
        }

        int max =0;
        int solMax =0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]){
                    visited = new int[N][M];
                    bfs(j,i);
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < M; l++) {
                            max = Math.max(max,visited[k][l]);
                        }
                    }
                    solMax = Math.max(solMax,max);
                }
            }
        }

        System.out.println(solMax-1);
    }

    public static void bfs(int x, int y){
        visited[y][x] = 1;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            int now[] = queue.poll();
            int now_x = now[0];
            int now_y = now[1];
            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if(next_x>=0&&next_y>=0&&next_x<M&&next_y<N){
                    if(map[next_y][next_x]&&visited[next_y][next_x]==0){
                        visited[next_y][next_x] = visited[now_y][now_x]+1;
                        queue.add(new int[]{next_x,next_y});
                    }
                }

            }


        }
    }
}
