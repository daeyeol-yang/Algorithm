

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Soo = Integer.parseInt(st.nextToken());

        int Dong = Integer.parseInt(st.nextToken());

        visited = new int[200001];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
        }

        bfs(Soo);

//        for (int i = 0; i < 200; i++) {
//            System.out.print(visited[i]+" ");
//        }

        System.out.println(visited[Dong]);
    }

    public static void bfs(int node){
        visited[node] = 0;
        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(node);

        while(!queue.isEmpty()){
            int now = queue.poll();

            int next1 = now*2;
            if(next1>=0&&next1<visited.length&&visited[next1]>visited[now]){
                visited[next1] = visited[now];
                queue.addFirst(next1);
            }
            for(int next : new int[]{now+1,now-1}){
                if(next>=0&&next<visited.length&&visited[next]>visited[now]){
                    visited[next] = visited[now]+1;
                    queue.addLast(next);

                }
            }


        }


    }
}
