

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }


        long lo = 0L;
        long hi = Long.MAX_VALUE;


        while(lo<hi){

            long mid = (lo + hi)/2;
            
            long result  = check(mid);


            if( result < K){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }

        System.out.println(lo-1);
    }


    public static long check(long mid){

        long count =0;

        for (int i = 0; i < N; i++) {
            count += arr[i]/mid;
        }

        //System.out.println(count);
        return count;

    }
}
