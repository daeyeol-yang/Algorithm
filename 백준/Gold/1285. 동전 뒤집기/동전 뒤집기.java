

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] arr;
    public static int N;

    public static int Min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        Min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            int value =1;
            for (int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j)=='T'){
                    arr[i] |= value;
                }
                value *=2;
            }
        }


        go(1);

        System.out.println(Min);
    }


    public static void go(int here){
        if(here == N+1){
            int sum =0;
            for (int i = 1; i <= (1<<(N-1)) ; i *= 2) {
                int cnt =0;
                for (int j = 0; j < N ; j++) {
                    if((i & arr[j]) !=0){

                        cnt++;
                    }

                }
                sum += Math.min(cnt,N-cnt);
            }

            Min = Math.min(Min, sum);
            return;
        }

        go(here+1);
        arr[here-1] = ~arr[here-1];
        go(here+1);


    }
}
