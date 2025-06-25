

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Road implements Comparable<Road>{

    int to;
    long distance;

    public Road(int to, long distance) {
        this.to = to;
        this.distance = distance;
    }

    @Override
    public int compareTo(Road o) {
        return Long.compare(this.distance , o.distance);
    }
}
public class Main {
    public static ArrayList<Road>[] map;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < TestCase; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken()); // 목적지 갯수
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int g = Integer.parseInt(st.nextToken())-1;
            int h = Integer.parseInt(st.nextToken())-1;

            map = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                map[i] = new ArrayList<>();
            }

            long GHDistantce = 0;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;
                long distance = Long.parseLong(st.nextToken());
                if((from==g&&to==h)||(from==h&&to==g)){
                    GHDistantce = distance;
                }
                map[from].add(new Road(to,distance));
                map[to].add(new Road(from,distance));
            }

            int[] end = new int[T];
            for (int i = 0; i < T; i++) {
                end[i] = Integer.parseInt(br.readLine())-1;
            }

            long distS[] = dik(s);
            long distG[] = dik(g);
            long distH[] = dik(h);

            List<Integer> sol = new ArrayList<>();

            for (int i = 0; i < T; i++) {

                if(distS[end[i]]==Long.MAX_VALUE){
                    continue;
                }

                long bestDistance = distS[end[i]];
                if(bestDistance == distG[s] + distH[end[i]] +GHDistantce || bestDistance == distG[end[i]] + distH[s] + GHDistantce){
                    sol.add(end[i]+1);
                }
            }
            Collections.sort(sol);

            for(int sol1 : sol){
                sb.append(sol1).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static long[] dik(int start){
        long[] dist = new long[N];
        Arrays.fill(dist , Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Road> pq = new PriorityQueue<>();

        pq.add(new Road(start,0));

        while(!pq.isEmpty()){
            Road nowRoad = pq.poll();
            int nowFrom = nowRoad.to;
            long nowDistance = nowRoad.distance;

            if(dist[nowFrom]!=nowDistance){
                continue;
            }

            for(Road nextRoad : map[nowFrom]){
                int nextRoadNode = nextRoad.to;
                long nextDistance = dist[nowFrom] + nextRoad.distance;

                if (dist[nextRoadNode] > nextDistance){
                    dist[nextRoadNode] = nextDistance;
                    pq.add(new Road(nextRoadNode, nextDistance));
                }
            }

        }
        return dist;
    }
}
