

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] map;

    public static long[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Soo = Integer.parseInt(st.nextToken());
        int Dong = Integer.parseInt(st.nextToken());

        map = new int[2000001];
        visited = new long[2000001];

        bfs(Soo);

        System.out.println(map[Dong]-1);
        System.out.println(visited[Dong]);
    }

    public static void bfs(int now) {
        map[now] = 1;
        visited[now] = 1;
        Queue<Integer> queue = new LinkedList();
        queue.add(now);
        while (!queue.isEmpty()) {
            int now1 = queue.poll();

            int next = now1 + 1;
            if (next < map.length) {
                if (map[next] == 0) {

                    queue.add(next);
                    map[next] = map[now1] + 1;
                    visited[next] += visited[now1];

                } else if (map[next] == map[now1] + 1) {

                    visited[next] += visited[now1];
                }
            }

            next = now1 - 1;
            if (next >= 0) {
                if (map[next] == 0) {

                    queue.add(next);
                    map[next] = map[now1] + 1;
                    visited[next] += visited[now1];

                } else if (map[next] == map[now1] + 1) {

                    visited[next] += visited[now1];
                }
            }

            next = now1 * 2;
            if (next < map.length) {
                if (map[next] == 0) {

                    queue.add(next);
                    map[next] = map[now1] + 1;
                    visited[next] += visited[now1];
                } else if (map[next] == map[now1] + 1) {

                    visited[next] += visited[now1];
                }
            }


        }
    }
}
