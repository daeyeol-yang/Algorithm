

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static int N, min, max;
    public static int[][] map;
    public static boolean[][] visited;
    public static Set<int[]> open;

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            visited = new boolean[N][N];

            go();

            if(check){
                break;
            }
            
            time++;


        }
        System.out.println(time);
    }

    public static void go() {
        int count =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!visited[i][j]) {
                    open = new HashSet<>();
                    bfs(j, i);

                    if(!open.isEmpty()) {
                        count++;


                        int average = 0;
                        int sum = 0;
                        for (int[] num : open) {
                            sum += map[num[1]][num[0]];

                        }
                        average = sum / open.size();

                        for (int[] num : open) {
                            map[num[1]][num[0]] = average;
                        }
                    }


                }

            }
        }
        if(count==0){
            check=true;
        }
    }

    public static void bfs(int x, int y) {
        visited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        open.add(new int[] {x, y});
        queue.add(new int[] {x, y});
        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int now_x = now[0];
            int now_y = now[1];

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if (next_x >= 0 && next_y >= 0 && next_x < N && next_y < N && !visited[next_y][next_x]) {
                    int cha = Math.abs(map[now_y][now_x] - map[next_y][next_x]);
                    if (min <= cha && cha <= max) {
                        visited[next_y][next_x] = true;
                        open.add(new int[] {next_x, next_y});
                        queue.add(new int[] {next_x, next_y});
                    }

                }

            }


        }
        if (open.size() == 1) {
            open.clear();
        }


    }

}
