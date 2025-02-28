import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static char[][] map;
    public static int[][] visited; // 고슴도치 이동 체크
    public static boolean[][] waterVisited; // 물 확장 체크

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static Queue<int[]> playerQueue = new LinkedList<>();
    public static Queue<int[]> waterQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];
        waterVisited = new boolean[N][M];

        int[] start = new int[2]; // 고슴도치 시작점
        int[] end = new int[2];   // 도착지점

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);

                if (map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                    visited[i][j] = 1;
                    playerQueue.add(new int[]{i, j});
                }

                if (map[i][j] == 'D') {
                    end[0] = i;
                    end[1] = j;
                }

                if (map[i][j] == '*') {
                    waterQueue.add(new int[]{i, j});
                    waterVisited[i][j] = true;
                }
            }
        }

        // BFS 실행 (물을 먼저 확장한 후 고슴도치 이동)
        bfs();

        // 결과 출력: 도착 가능 여부 확인
        int result = visited[end[0]][end[1]];
        System.out.println(result == 0 ? "KAKTUS" : result - 1);
    }

    public static void bfs() {
        while (!playerQueue.isEmpty()) {
            // 1. 물 확장
            int waterSize = waterQueue.size();
            for (int i = 0; i < waterSize; i++) {
                int[] water = waterQueue.poll();
                int wx = water[0], wy = water[1];

                for (int d = 0; d < 4; d++) {
                    int nx = wx + dx[d];
                    int ny = wy + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (!waterVisited[nx][ny] && map[nx][ny] == '.') {
                            map[nx][ny] = '*';  // 물 확장
                            waterVisited[nx][ny] = true;
                            waterQueue.add(new int[]{nx, ny});
                        }
                    }
                }
            }

            // 2. 고슴도치 이동
            int playerSize = playerQueue.size();
            for (int i = 0; i < playerSize; i++) {
                int[] player = playerQueue.poll();
                int px = player[0], py = player[1];

                for (int d = 0; d < 4; d++) {
                    int nx = px + dx[d];
                    int ny = py + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        // 'D'에 도착하면 즉시 종료
                        if (map[nx][ny] == 'D') {
                            visited[nx][ny] = visited[px][py] + 1;
                            return;
                        }

                        // 이동 가능하면 이동
                        if (visited[nx][ny] == 0 && map[nx][ny] == '.') {
                            visited[nx][ny] = visited[px][py] + 1;
                            playerQueue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}
