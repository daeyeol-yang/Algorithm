

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int map[][];
    public static boolean visited[][];

    public static int N, M;

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int count = 0;

        while (true) {
            realCheckAir();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && check(j, i)) {
                        map[i][j] = 2;
                    }
                }
            }
           



            if (endCheck()) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] == 2) {
                            count++;
                        }
                    }
                }
                break;
            }

            time++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 2) {
                        map[i][j] = 0;
                    }
                }
            }


        }


        System.out.println(time + 1);
        System.out.println(count);


    }


    public static boolean endCheck() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean check(int x, int y) {
        



        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N) {

                if (map[next_y][next_x] == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void realCheckAir() {
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    dfs(0, 0);
                }
            }
        }

    }

    public static void dfs(int x, int y) {
        visited[y][x] = true;
        map[y][x] =3;

        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N && map[next_y][next_x] != 1&&map[next_y][next_x] != 2&&!visited[next_y][next_x]) {
                dfs(next_x, next_y);
            }
        }
    }
}
