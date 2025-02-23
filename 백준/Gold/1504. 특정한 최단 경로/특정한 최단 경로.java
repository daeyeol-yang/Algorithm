

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node{
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }


    public static ArrayList<Node>[] map;
    public static int[] dist1;
    public static int[] dist2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        map = new ArrayList[N];


        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int distance = Integer.parseInt(st.nextToken());

            map[start].add(new Node(end,distance));
            map[end].add(new Node(start,distance));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken())-1;
        int v2 = Integer.parseInt(st.nextToken())-1;

        int[] map1 = new int[4];
        int[] map2  = new int[4];
        map1[0] = 0;
        map1[1] = v1;
        map1[2] = v2;
        map1[3] = N-1;
        map2[0] = 0;
        map2[1] = v2;
        map2[2] = v1;
        map2[3] = N-1;

        boolean check = false;
        int sol1 =0;
        int sol2 =0;
        for (int i = 0; i < 3; i++) {
            dist1 = new int[N];
            dist2 = new int[N];
            for (int i1 = 0; i1 < N; i1++) {
                dist1[i1] = Integer.MAX_VALUE;
                dist2[i1] = Integer.MAX_VALUE;
            }
            dist1[map1[i]]=0;
            dist2[map2[i]]=0;

           dist1 =  di(map1[i],dist1);
            int num1= dist1[map1[i+1]];
            if(num1==Integer.MAX_VALUE){
                check= true;
                break;
            }

            dist2 = di(map2[i],dist2);
            int num2= dist2[map2[i+1]];
            if(num2==Integer.MAX_VALUE){
                check= true;
                break;
            }

            sol1 += num1;
            sol2 += num2;

            //System.out.println(Arrays.toString(dist1));
            //System.out.println(Arrays.toString(dist2));

        }

        if(check){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(sol1,sol2));
        }


    }


    public static int[] di(int node,int[] dist){
        //PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.distance - o2.distance);
        Queue<Node> pq = new LinkedList<>();
        pq.add(new Node(node,0));


        while(!pq.isEmpty()){
            Node nowNodeTemp = pq.poll();
            int nowNode = nowNodeTemp.node;
            int nowDistance = nowNodeTemp.distance;

            if(nowDistance!=dist[nowNode]) continue;

            for(Node nextNodeTemp : map[nowNode]){
                int nextNode = nextNodeTemp.node;
                int nextDistance = nextNodeTemp.distance;

                if(dist[nextNode] > dist[nowNode] + nextDistance){
                    dist[nextNode] = dist[nowNode] + nextDistance;
                    pq.add(new Node(nextNode, dist[nextNode]));
                }
            }

        }
        return dist;

    }
}
