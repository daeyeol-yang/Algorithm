

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long N,M;
    public static long sol = Integer.MAX_VALUE;

    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[(int)M];


        long left =1;
        long right =0;
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right,arr[i]);
        }

        while(left<=right){
            long mid = (left+right)/2;

            if(check(mid)){
                right = mid-1;
                sol = Math.min(sol,mid);
            }else{
                left = mid+1;
            }

        }

        System.out.println(sol);

    }

    public static boolean check(long mid){
        long count =0;
        for (int i = 0; i < M ; i++) {
            count += arr[i]/mid;
            count+= arr[i]%mid==0?0:1;
        }
        return count<=N;
    }
}
