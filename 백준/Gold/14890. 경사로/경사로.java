

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, L, sol;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());


        int[][] map = new int[N][N];
        int[][] map1 = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                map1[j][i] = map[i][j];
            }
        }

        go(map);
        go(map1);

        System.out.println(sol);


    }

    public static void go(int[][] map){
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            int j;
            for (j = 0; j < N-1; j++) {
                if(map[i][j] == map[i][j+1]){
                    cnt++;
                } else if (map[i][j]+1==map[i][j+1] && cnt >= L) {
                    cnt =1;
                } else if (map[i][j]-1 == map[i][j+1] && cnt >=0) {
                    cnt = 1 -L;
                }else{
                    break;
                }


            }

            if(j==N-1&& cnt >=0){
                sol++;
            }
        }


    }
}
