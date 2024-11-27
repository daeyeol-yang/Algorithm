

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int M, N;
    public static boolean[][] visited;

    public static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        visited = new boolean[M+1][N+1];

        min = Integer.MAX_VALUE;


        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            int se = Integer.parseInt(st.nextToken());
            int ga = Integer.parseInt(st.nextToken());

            visited[se][ga] = true;
        }


        go(1,0);

        if(min==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }


    }

    public static boolean check(){

        for (int i = 1; i <= N; i++) {
            int node = i;
            for (int j = 1; j <=M ; j++) {
                if(visited[j][node]){
                    node++;
                } else if (visited[j][node-1]) {
                    node--;
                }
            }
            if(node!=i){
                return false;
            }
        }
        return true;

    }

    public static void go(int now, int count){
        if(count>3){
            return;
        }

        if(count>=min){
            return;
        }

        if(check()){
            min = Math.min(min,count);
            return;
        }

        for (int i = now; i <= M; i++) {
            for (int j = 1; j < N ; j++) {
                if(!visited[i][j]&&!visited[i][j-1]&&!visited[i][j+1]){
                            visited[i][j]=true;
                            go(i,count+1);
                            visited[i][j] = false;



                }
            }
        }
    }
}
