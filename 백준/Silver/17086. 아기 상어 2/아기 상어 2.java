
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static boolean[][] map;
    public static boolean[][] visited;
    public static int d;

    public static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    public static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;

            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                d = 0;
                if (!map[i][j]) {
                    visited = new boolean[N][M];
                    bfs(j, i);
                    arrayList.add(d);
                }
            }
        }

        arrayList.sort(Comparator.reverseOrder());
        System.out.println(arrayList.get(0) + 1);


    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int now[] = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int next_x = now[0] + dx[i];
                    int next_y = now[1] + dy[i];


                    if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N && !visited[next_y][next_x]) {
                        visited[next_y][next_x] = true;
                        queue.add(new int[] {next_x, next_y});
                        if (map[next_y][next_x]) {
                            return;
                        }
                    }

                }


            }
            d++;


        }


    }
}
