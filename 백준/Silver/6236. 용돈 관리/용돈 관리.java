import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static int[] arr;

    public static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int low = 0;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            low = Math.max(low,arr[i]);
        }

        int high = 1000000001;
        int sol =0;

        while(low<=high){

            int mid = (low+high)/2;

            if(check(mid)){
                high = mid -1;
                sol = mid;
            }else{
                low= mid+1;

            }

        }

        System.out.println(sol);

    }

    public static boolean check(int mid){
        int count =1;
        int temp = mid;
        for (int i = 0; i < N; i++) {
            if(mid - arr[i] <0){
                mid = temp;
                count ++;
            }
            mid -= arr[i];
        }

        return count <= M;

    }
}
