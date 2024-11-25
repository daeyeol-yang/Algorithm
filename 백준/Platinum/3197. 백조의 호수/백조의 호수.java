import java.io.*;
import java.util.*;

public class Main {

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static int N, M;
    public static char[][] map;
    public static int[][] visitedSwan, visitedWater;
    public static Queue<int[]> waterQueue = new LinkedList<>();
    public static Queue<int[]> swanQueue = new LinkedList<>();
    public static Queue<int[]> nextSwanQueue = new LinkedList<>();
    public static int swanX1, swanY1, swanX2, swanY2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visitedSwan = new int[N][M];
        visitedWater = new int[N][M];

        boolean firstSwanFound = false;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'L') {
                    if (!firstSwanFound) {
                        swanY1 = i;
                        swanX1 = j;
                        firstSwanFound = true;
                    } else {
                        swanY2 = i;
                        swanX2 = j;
                    }
                    map[i][j] = '.';
                }
                if (map[i][j] == '.') {
                    waterQueue.add(new int[]{i, j});
                    visitedWater[i][j] = 1;
                }
            }
        }

        swanQueue.add(new int[]{swanY1, swanX1});
        visitedSwan[swanY1][swanX1] = 1;

        int days = 0;

        while (true) {
            if (canSwanMeet()) {
                System.out.println(days);
                break;
            }

            meltIce();
            days++;
        }
    }

    public static boolean canSwanMeet() {
        while (!swanQueue.isEmpty()) {
            int[] current = swanQueue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visitedSwan[ny][nx] == 1) continue;

                visitedSwan[ny][nx] = 1;

                if (ny == swanY2 && nx == swanX2) {
                    return true;
                }

                if (map[ny][nx] == '.') {
                    swanQueue.add(new int[]{ny, nx});
                } else if (map[ny][nx] == 'X') {
                    nextSwanQueue.add(new int[]{ny, nx});
                }
            }
        }

        swanQueue = nextSwanQueue;
        nextSwanQueue = new LinkedList<>();
        return false;
    }

    public static void meltIce() {
        int size = waterQueue.size();

        for (int i = 0; i < size; i++) {
            int[] current = waterQueue.poll();
            int y = current[0];
            int x = current[1];

            for (int j = 0; j < 4; j++) {
                int ny = y + dy[j];
                int nx = x + dx[j];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visitedWater[ny][nx] == 1) continue;

                if (map[ny][nx] == 'X') {
                    map[ny][nx] = '.';
                    waterQueue.add(new int[]{ny, nx});
                }

                visitedWater[ny][nx] = 1;
            }
        }
    }
}
