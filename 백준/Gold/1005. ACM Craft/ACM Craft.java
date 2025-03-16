

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TEST_CASE = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int testCase = 0; testCase < TEST_CASE; testCase++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] map = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                map[i] = new ArrayList<>();
            }

            int[] chasu = new int[N];
            int[] time = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken())-1;
                int end = Integer.parseInt(st.nextToken())-1;

                map[start].add(end);
                chasu[end]++;
            }


            Queue<Integer> queue = new ArrayDeque<>();
            int[] sol = new int[N];

            for (int i = 0; i < N; i++) {
                if(chasu[i] ==0 ){
                    queue.add(i);
                    sol[i] = time[i];
                }
            }

            int END = Integer.parseInt(br.readLine())-1;



            while(!queue.isEmpty()){

                int now = queue.poll();

                if(END == now){
                    break;
                }

                for(int next : map[now]){
                    chasu[next]--;
                    if(sol[next]<sol[now]+time[next]){
                        sol[next] = sol[now]+time[next];
                    }
                    if(chasu[next]==0){
                        queue.add(next);
                    }
                }


            }

           sb.append(sol[END]).append('\n');

        }
        System.out.println(sb);

    }
}
