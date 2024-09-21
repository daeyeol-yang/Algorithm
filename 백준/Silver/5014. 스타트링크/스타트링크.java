

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int F,S,G,U,D;
    public static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[F+1];
        bfs(S);
        if(visited[G]==0){
            System.out.println("use the stairs");
        }else{
            System.out.println(visited[G]-1);
        }
    }

    public static void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n]++;
        while (!queue.isEmpty()){

            int now = queue.poll();

            if(now==G){
                return;
            }
            if(now+U<=F&&visited[now+U]==0){
                queue.add(now+U);
                visited[now+U] = visited[now]+1;
            }

            if(now-D>0 && visited[now-D]==0){
                queue.add(now-D);
                visited[now-D] = visited[now]+1;
            }



        }



    }
}
