

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arrSum = new long[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <=N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            arrSum[i]= arrSum[i-1] + num;
        }


        int count=0;

        for (int i = 1; i <=N ; i++) {
            for (int j = i; j <=N ; j++) {
                long target = arrSum[j]-arrSum[i-1];
                if(target==M){
                    count++;
                }
                
            }
        }
        System.out.println(count);

    }
}
