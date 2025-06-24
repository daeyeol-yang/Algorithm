

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int to;
    long distance;

    public Node(int to, long distance) {

        this.to = to;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.distance,o.distance);
    }
}
public class Main {

    static ArrayList<Node>[] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken())-1;
        int B = Integer.parseInt(st.nextToken())-1;
        int C = Integer.parseInt(st.nextToken())-1;
        int M = Integer.parseInt(br.readLine());

        map = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken())-1;
            int from = Integer.parseInt(st.nextToken())-1;
            int distance = Integer.parseInt(st.nextToken());
            map[from].add(new Node(to,distance));
            map[to].add(new Node(from,distance));

        }


        long distA[] =dik(A);
        long distB[] = dik(B);
        long distC[] = dik(C);


        int sol = -1;
        long max = 0;
        for (int i = 0; i < N; i++) {
            if(distA[i]==Long.MAX_VALUE || distB[i]==Long.MAX_VALUE || distC[i] == Long.MAX_VALUE){
                continue;
            }
            long minDist = Math.min(distA[i], Math.min(distB[i], distC[i]));
            if (minDist > max) {
                max = minDist;
                sol = i + 1;
            }

        }



        System.out.println(sol);

    }

    public static long[] dik(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        long dist[] = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node nowNode = pq.poll();
            int nowTo = nowNode.to;
            long nowDistance = nowNode.distance;
            if(dist[nowTo]!=nowDistance){
                continue;
            }

            for(Node nextNode : map[nowTo]){
                int nextTo = nextNode.to;
                long nextDistance = nextNode.distance+dist[nowTo];

                if(dist[nextTo] > nextDistance){
                    dist[nextTo] = nextDistance;
                    pq.add(new Node(nextTo,nextDistance));
                }
            }
        }
        return dist;
    }
}
