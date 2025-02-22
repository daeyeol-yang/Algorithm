

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Point{
        int node;
        int time;

        public Point(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    public static ArrayList<Point>[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int END = Integer.parseInt(st.nextToken())-1;


        map = new ArrayList[N];
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int time = Integer.parseInt(st.nextToken());

            map[start].add(new Point(end,time));
        }

        for (int start = 0; start < N; start++) {
            dist[start][start]=0;
            di(start,dist[start]);
        }

        int sol =0;

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dist[i]));
//        }

        for (int start = 0; start < N; start++) {
            sol = Math.max(sol, dist[start][END]+dist[END][start]);
        }

        System.out.println(sol);
    }

    public static void di(int node, int[] dist){
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.time- o2.time);
        pq.add(new Point(node,dist[node]));

        while (!pq.isEmpty()){
            Point nowPoint = pq.poll();
            int nowNode = nowPoint.node;
            int nowTime = nowPoint.time;

            if(nowTime!=dist[nowNode])continue;

            for(Point nextPoint : map[nowNode]){
                int nextNode = nextPoint.node;
                int nextTime = nextPoint.time;

                int distance = dist[nowNode]+nextTime;

                if(dist[nextNode]>distance){
                    dist[nextNode] = distance;
                    pq.add(new Point(nextNode,dist[nextNode]));
                }

            }

        }

    }
}
