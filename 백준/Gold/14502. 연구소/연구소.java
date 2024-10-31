

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer> arrayList;

    public static int N, M;

    public static int[][] map;

    public static int[][] visited;

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// 입력값 받기


        makeWall(0);
        Collections.sort(arrayList, Collections.reverseOrder());
        System.out.println(arrayList.get(0));

    }

    public static void makeWall(int size) {
        if (size == 3) {
            virusGo();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(size + 1);
                    map[i][j] = 0;
                }

            }
        }
    }


    public static void virusGo() {

        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    visited[i][j] = 1;
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0 && map[i][j] == 2) {

                    dfs(j, i);

                }
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    count++;
                }
            }
        }





        arrayList.add(count);


    }

    public static void dfs(int x, int y) {
        visited[y][x] = 2;

//        for (int k = 0; k < N; k++) {
//            System.out.println(Arrays.toString(visited[k]));
//        }
//        System.out.println();

        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N) {
                if (visited[next_y][next_x] == 0) {
                    dfs(next_x, next_y);
                }
            }
        }
    }
}
