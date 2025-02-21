
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
        int value;

        Point(int node,int value){
            this.node = node;
            this.value = value;
        }
    }

    public static int[] dist;
    public static ArrayList<Point>[] map;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int go = Integer.parseInt(br.readLine())-1;


        map = new ArrayList[N];

        dist = new int[N];

        for(int i=0; i<N ; i++) {
            map[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<E ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());

            map[start].add(new Point(end,value));

        }

        dist[go]=0;

        di(go);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N ;i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            }else {

                sb.append(dist[i]);
            }
            sb.append('\n');
        }

        System.out.println(sb);



    }

    public static void di(int node) {
        PriorityQueue<Point> queue = new PriorityQueue<>(((o1,o2)->o1.value-o2.value));
        queue.add(new Point(node,dist[node]));

        while(!queue.isEmpty()) {
            Point temp = queue.poll();
            int nowNode = temp.node;
            int nowValue = temp.value;

            if(nowValue!=dist[nowNode]) {
                continue;
            }


            for(Point nextPoint :  map[nowNode]) {
                int nextNode = nextPoint.node;
                int nextValue = nextPoint.value;
                if(dist[nextNode]>dist[nowNode]+nextValue) {
                    dist[nextNode] = dist[nowNode] + nextValue;
                    queue.add(new Point(nextNode,dist[nextNode]));
                }
            }
        }


    }

}

