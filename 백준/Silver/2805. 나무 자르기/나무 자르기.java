import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());

        long max =0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }
        //max++;



        long lo = 0;
        long hi = max;

        while(lo<hi){

            long mid = (lo+hi)/2;

            long count =0;
            for (int i = 0; i < N; i++) {
                count+= Math.max(arr[i]-mid,0L);
            }


            if(M>count){
                hi =mid;
            }else{
                lo = mid+1;
            }



        }

        System.out.println(lo-1);
    }
}
