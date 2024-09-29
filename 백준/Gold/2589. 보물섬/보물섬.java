

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N,M;

    public static char[][] map;
    public static int[][] visited;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static ArrayList<Integer> arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new int[N][M];

                if(map[i][j]=='L'){
                    bfs(j,i);
                }
            }
        }

        arrayList.sort(Comparator.reverseOrder());

        System.out.println(arrayList.get(0)-1);
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
                int next_x = now_x+dx[i];
                int next_y = now_y+dy[i];
                if(next_x>=0&&next_y>=0&&next_x<M&&next_y<N&&map[next_y][next_x]=='L'&&visited[next_y][next_x]==0){
                    queue.add(new int[]{next_x,next_y});
                    visited[next_y][next_x] = visited[now_y][now_x]+1;
                    arrayList.add(visited[next_y][next_x]);
                }

            }



        }
    }
}
