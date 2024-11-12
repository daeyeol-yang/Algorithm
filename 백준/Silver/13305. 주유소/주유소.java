

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] money = new int[N-1];
        long[] city = new long[N-1];

        StringTokenizer

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            money[i] = Integer.parseInt(st.nextToken());

        }
        int minCost = money[0];

        long sum = 0;

        for (int i = 0; i < N-1; i++) {
            minCost = Math.min(minCost,money[i]);
            sum += minCost*city[i];
        }


        System.out.println(sum);




    }
}
