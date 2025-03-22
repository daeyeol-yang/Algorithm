
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static long[] time;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());



        time = new long[N];
        long max = 0;

        for(int i = 0 ; i < N ; i++ ) {
            time[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, time[i]);
        }

        long lo = 1;
        long hi = max * M;
        long answer =0L;

        while(lo<=hi) {
            long mid = (lo+hi)/2;


            long human = check(mid);

            if(M>human) {

                lo = mid+1;

            }
            else {
                answer = mid;
                hi = mid -1;
            }


        }

        System.out.println(answer);
    }


    public static long check(long mid) {

        long human =0;

        for(int i = 0; i< N ;i++) {

            human += mid/time[i];

            if(human>=M) {
                return M;
            }

        }

    return human;

    }
}
