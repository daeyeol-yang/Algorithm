

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][] visited;

    public static int Dong;

    public static int sol,time;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new int[2][500001];

        int Soo = Integer.parseInt(st.nextToken());

        Dong = Integer.parseInt(st.nextToken());

        bfs(Soo);

        System.out.println(sol);
    }

    public static void bfs(int node){

        if(node==Dong){

            return;
        }

        visited[0][node] = 1;
        Deque<Integer> Soodeque = new ArrayDeque<>();
        Soodeque.add(node);
        int now_Dong = Dong;

        time =1;

        while (!Soodeque.isEmpty()){


            now_Dong+=time;

            if(now_Dong>500000){

                sol = -1;
                return;
            }


            if(visited[time%2][now_Dong]!=0){
                sol = time;
                break;
            }


            // 5   6  8 11 15 20
            // 17 16 17 18  19 20


            int size = Soodeque.size();

            for (int i = 0; i < size; i++) {

                int now = Soodeque.poll();

                for (int next : new int[] {now + 1, now - 1, now * 2}) {
                    if (next >= 0 && next < visited[0].length&&visited[time%2][next]==0) {
                        visited[time%2][next] = visited[(time+1)%2][now] + 1;
                        if (next == now_Dong) {
                            sol = time;

                            return;
                        }
                        Soodeque.add(next);
                    }
                }
            }
            time++;



        }




    }
}
