

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N+2];
        int[] money = new int[N+2];
        int[] dp = new int[N+2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tempTime = Integer.parseInt(st.nextToken());
            int tempMoney = Integer.parseInt(st.nextToken());

            time[i] = tempTime;
            money[i] = tempMoney;
        }

        for (int i = N; i >=1 ; i--) {
            if(i+time[i]>N+1){
                dp[i] = dp[i+1];
                //continue;
            }else{

                dp[i] = dp[i+time[i]]+money[i];
                dp[i] = Math.max(dp[i],dp[i+1]);

            }


        }



        System.out.println(dp[1]);
    }
}
