

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {-2,-2,0,0,2,2};
    public static int[] dy = {-1,1,-2,2,-1,1};

    public static int[][] map;

    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        bfs(startX,startY);

        if(map[endY][endX]==0){
            System.out.println(-1);
        }else {
            System.out.println(map[endY][endX]);
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 6; i++) {
                int next_x = nowX+dx[i];
                int next_y = nowY+dy[i];
                if(next_x>=0&&next_y>=0&&next_x<N&&next_y<N&&map[next_y][next_x]==0){
                    map[next_y][next_x] = map[nowY][nowX] + 1;
                    queue.add(new int[]{next_x,next_y});
                }
            }

        }


    }
}
