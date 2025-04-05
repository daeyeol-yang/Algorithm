

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

     static class Node implements Comparable<Node>{
            int node;
            int weight;

         public Node(int node, int weight) {
             this.node = node;
             this.weight = weight;
         }

         @Override
         public int compareTo(Node o) {
             return Integer.compare(this.weight,o.weight);
         }
     }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N];
        dist = new int[N];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());

            map[from].add(new Node(to , weight));
            map[to].add(new Node(from , weight));
        }

        dik(0);
        //System.out.println(Arrays.toString(dist));
        System.out.println(dist[N-1]);
    }
    static ArrayList<Node> map[];
    static int[] dist;
    public static void dik(int start){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node nowNode = pq.poll();

            int now = nowNode.node;

            int nowWeight = nowNode.weight;

            if(dist[now]!=nowWeight){
                continue;
            }

            for(Node nextNode : map[now]){
                int next = nextNode.node;
                int nextWeight = nextNode.weight;

                if(dist[next] > dist[now] + nextWeight){
                    dist[next] = dist[now] + nextWeight;
                    pq.add(new Node(next , dist[next]));
                }


            }


        }


    }


}
