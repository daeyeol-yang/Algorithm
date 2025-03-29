

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight,o.weight);
        }
    }

    static List<Edge> edgeList;
    static int N;

    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();

        long sum =0;

        for(int i = 0 ; i< M ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());
            sum += weight;
            edgeList.add(new Edge(from, to, weight));
        }
        make();
        Collections.sort(edgeList);

        int count =0;
        long result=0;
        boolean check =false;
        for(Edge edge : edgeList){
            int from = edge.from;
            int to = edge.to;
            int weight = edge.weight;

            if(union(from,to)){
                result+=weight;

                if(++count==N-1){
                    check =true;
                    break;
                }
            }

        }

        if(!check){
            System.out.println(-1);
        }else{
            System.out.println(sum- result);
        }

    }

    static void make(){
        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i]=i;
        }
    }

    static int find(int a){
        if(a==p[a]){
            return a;
        }

        return p[a] = find(p[a]);
    }

    static boolean union(int a ,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB){
            return false;
        }

        p[rootB] = rootA;
        return  true;

    }
}
