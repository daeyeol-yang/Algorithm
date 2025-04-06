import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final int INF = 1000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] caffein = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            caffein[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                // 선택하지 않은 경우
                dp[i][j] = dp[i - 1][j];

                // 선택한 경우
                if (j >= caffein[i]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - caffein[i]] + 1);
                }
            }
        }

        System.out.println(dp[N][M] >= INF ? -1 : dp[N][M]);
    }
}
