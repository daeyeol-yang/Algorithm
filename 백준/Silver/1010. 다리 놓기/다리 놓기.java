

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test =Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            System.out.println(combi(R,N));
        }
    }

    public static int combi(int n, int r){
        // 이미 풀린 경우 바로 반환
        if(dp[n][r] > 0) {
            return dp[n][r];
        }

        // 2번 성질
        if(n == r || r == 0) {
            return dp[n][r] = 1;
        }

        // 1번 성질
        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);

//        if(dp[n][r] > 0){
//            return dp[n][r];
//        }
//
//        if(r==0||n==r){
//            dp[n][r] = 1;
//            return dp[n][r];
//        }
//        return  dp[n][r]= combi(n-1,r-1) + combi(n-1,r);
    }
}
