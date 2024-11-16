

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new int[31][31];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==j){
                    dp[i][j] =1;
                }
                if(j==0){
                    dp[i][j]=1;
                }
            }
        }

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        System.out.println(combi(N-1,R-1));


    }

    public static int combi(int n, int r){
        if(dp[n][r]>0){
            return dp[n][r];
        }

        return dp[n][r] = combi(n-1,r) + combi(n-1,r-1);
    }
}
