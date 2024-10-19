

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] pArr = new int[N+1];
        int[] arr = new int[N+1];

        st= new StringTokenizer(br.readLine());

//        for (int i = 1; i <= N; i++) {
//            arr[i]= Integer.parseInt(st.nextToken());
//        }
//        System.out.println(Arrays.toString(arr));
//
//        for (int i = 1; i <=N ; i++) {
//            pArr[i] = pArr[i-1]+arr[i];
//        }
//        System.out.println(Arrays.toString(pArr));

        for (int i = 1; i <= N ; i++) {
            pArr[i] = pArr[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N-K+1; i++) {
            max = Math.max(max,pArr[i+K]-pArr[i]);
        }

        System.out.println(max);


    }
}
