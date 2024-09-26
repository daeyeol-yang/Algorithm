

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int size;

    public static int[][] map;

    public static int dx[] = {-2, -1, 1, 2,-2,-1,1,2};
    public static int dy[] = {1, 2, 2, 1,-1,-2,-2,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());


        for (int test = 0; test < testCase; test++) {
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(st.nextToken());
            int nowY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            bfs(nowX,nowY);

            map[nowY][nowX]=0;

            System.out.println(map[targetY][targetX]);

        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            int now[] = queue.poll();
            for (int i = 0; i < 8; i++) {

                int next_x = now[0]+dx[i];
                int next_y = now[1]+dy[i];
                if(next_x>=0&&next_y>=0 && next_x<size && next_y<size&&map[next_y][next_x]==0){
                    map[next_y][next_x]=map[now[1]][now[0]]+1;
                    queue.add(new int[]{next_x,next_y});
                }
                }





        }




    }
}
