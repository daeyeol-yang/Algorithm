
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int M;
    public static int[] arr;

    public static long temp, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        if(N<=M){
            System.out.println(N);
            System.exit(0);
        }

        long low =0;
        long high =60000000004L;

        long sol =0;

        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        while(low<=high){
            long mid = (low+high)/2;

            if(check(mid)){
                sol = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        }

        temp = M;

        for (int i = 0; i < M ; i++) {
            temp += (sol-1)/arr[i];
        }

        for (int i = 0; i < M; i++) {
            if(sol%arr[i]==0) temp++;
            if(temp==N){
                System.out.println(i+1);
                break;
            }
            
        }
    }

    public static boolean check(long mid){
        temp =M;

        for (int i = 0; i < M; i++) {
            temp += mid/arr[i];
        }
        return temp >= N;
    }
}
