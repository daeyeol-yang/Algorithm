

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dataSize = Integer.parseInt(st.nextToken());
        int quiz = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int [] arr = new int[dataSize+1];

        for (int i = 1; i <= dataSize; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        long [] arrSum = new long[dataSize+1];

        for (int i = 1; i <= dataSize ; i++) {
            arrSum[i] = arrSum[i-1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < quiz; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long sum = arrSum[end] - arrSum[start-1];
            sb.append(sum).append('\n');
        }

        System.out.println(sb);
    }
}
