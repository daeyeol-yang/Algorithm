import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static char[][] map;
    public static boolean check = false;
    public static int[][] fire_visited;
    public static int[][] J_visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int J_now_x = 0, J_now_y = 0;
        ArrayList<int[]> fireList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'F') {
                    fireList.add(new int[]{j, i});
                } else if (map[i][j] == 'J') {
                    J_now_x = j;
                    J_now_y = i;
                }
            }
        }

        // -1로 초기화하여 방문 여부 체크
        fire_visited = new int[N][M];
        J_visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                fire_visited[i][j] = -1;
                J_visited[i][j] = -1;
            }
        }

        bfs(fireList);
        int result = bfsJ(J_now_x, J_now_y);
        
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    public static void bfs(ArrayList<int[]> fireList) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] pos : fireList) {
            int x = pos[0], y = pos[1];
            fire_visited[y][x] = 0;
            queue.add(new int[]{x, y});
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_x = now[0], now_y = now[1];

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N) {
                    if (fire_visited[next_y][next_x] == -1 && map[next_y][next_x] != '#') {
                        fire_visited[next_y][next_x] = fire_visited[now_y][now_x] + 1;
                        queue.add(new int[]{next_x, next_y});
                    }
                }
            }
        }
    }

    public static int bfsJ(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        J_visited[y][x] = 0;
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_x = now[0], now_y = now[1];

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                // 탈출 조건 확인
                if (next_x < 0 || next_y < 0 || next_x >= M || next_y >= N) {
                    return J_visited[now_y][now_x] + 1;
                }

                // 이동 가능 여부와 방문 여부 확인
                if (J_visited[next_y][next_x] == -1 && map[next_y][next_x] != '#') {
                    if (fire_visited[next_y][next_x] == -1 || fire_visited[next_y][next_x] > J_visited[now_y][now_x] + 1) {
                        J_visited[next_y][next_x] = J_visited[now_y][now_x] + 1;
                        queue.add(new int[]{next_x, next_y});
                    }
                }
            }
        }
        return -1;  // 탈출 경로가 없을 경우
    }
}
