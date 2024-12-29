

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j)-'0';
            }
        }

        int max = Integer.MIN_VALUE;


        for (int testCase = 0; testCase < (1<<N*M); testCase++) {
            int sum = 0;

            //가로

            for (int i = 0; i < N; i++) {
                int garoCur = 0;
                for (int j = 0; j < M; j++) {
                    int k = i * M + j;
                    if((testCase & (1<<k))==0 ){
                        garoCur = garoCur*10 + map[i][j];
                    }else{
                        sum += garoCur;
                        garoCur =0;
                    }
                }
                sum += garoCur;
            }

            for (int j = 0; j < M; j++) {
                int seroCur=0;
                for (int i = 0; i < N; i++) {
                    int k = i * M + j;

                    if((testCase & (1<<k))!=0){
                        seroCur = seroCur*10 + map[i][j];
                    }else{
                        sum += seroCur;
                        seroCur =0;
                    }
                }
                sum += seroCur;
            }

            max = Math.max(sum,max);
        }

        System.out.println(max);
    }
}
