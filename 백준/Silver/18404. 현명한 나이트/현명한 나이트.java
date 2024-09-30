

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    public static int[] dy = {-1,1,-2,2,-2,2,-1,1};

    public static int size;

    public static int[][] map;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());

        map = new int[size][size];

        visited  = new boolean[size][size];

        int count = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        bfs(startX-1, startY-1);
        for (int i1 = 0; i1 < count; i1++) {
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            sb.append(map[targetY-1][targetX-1]).append(" ");

        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y){
        visited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int now_x = now[0];
                int now_y = now[1];
                int next_x = now_x+dx[i];
                int next_y = now_y+dy[i];

                if(next_x>=0&&next_y>=0&&next_x<size&&next_y<size&&!visited[next_y][next_x]){
                    map[next_y][next_x]=map[now_y][now_x]+1;
                    visited[next_y][next_x]=true;
                    queue.add(new int[]{next_x,next_y});

                }
            }


        }


    }
}
