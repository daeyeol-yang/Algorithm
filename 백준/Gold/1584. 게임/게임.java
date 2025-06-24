

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
    int x;
    int y;

    int life;

    public Point(int x, int y, int life) {
        this.x = x;
        this.y = y;
        this.life = life;
    }

    @Override
    public int compareTo(Point o) {
        return Integer.compare(this.life,o.life);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dangerCount = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[501][501];
        for (int i = 0; i < dangerCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int minY = Math.min(y1,y2);
            int maxY = Math.max(y1,y2);
            int minX = Math.min(x1,x2);
            int maxX = Math.max(x1,x2);
            for (int j = minY; j <= maxY ; j++) {
                for (int k = minX; k <= maxX ; k++) {
                    map[j][k] = 1;
                }
            }
        }
        int deathCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < deathCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int minY = Math.min(y1,y2);
            int maxY = Math.max(y1,y2);
            int minX = Math.min(x1,x2);
            int maxX = Math.max(x1,x2);
            for (int j = minY; j <= maxY ; j++) {
                for (int k = minX; k <= maxX ; k++) {
                    map[j][k] = Integer.MAX_VALUE;
                }
            }
        }

        dist = new int[501][501];
        for (int i = 0; i < 501; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        dist[0][0] = 0;
        dik(0,0);

        System.out.println(dist[500][500]==Integer.MAX_VALUE?-1:dist[500][500]);


    }

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] dist;
    static int[][] map;


    public static boolean isIn(int x , int y){
        return 0<=x && x<501 && 0<=y && y<501;
    }

    public static void dik(int x, int y){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(x,y,0));

        while(!pq.isEmpty()){
            Point nowPoint = pq.poll();
            int nowX = nowPoint.x;
            int nowY = nowPoint.y;
            int nowLife = nowPoint.life;
            if(dist[nowY][nowX]!=nowLife){
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX+dx[i];
                int nextY = nowY+dy[i];

                if(!isIn(nextX,nextY)){
                    continue;
                }

                if(map[nextY][nextX]==Integer.MAX_VALUE){
                    continue;
                }
                int nextLife = nowLife+map[nextY][nextX];


                if(dist[nextY][nextX] > nextLife ){
                    dist[nextY][nextX] = nextLife;
                    pq.add(new Point(nextX,nextY,nextLife));
                }
            }


        }
    }
}
