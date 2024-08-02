
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long [] arr = new long[(int)N];
        long num=0;
        for (int i = 0; i < N ; i++) {
            arr[i]= Long.parseLong(st.nextToken());

        }

        long M = Long.parseLong(br.readLine());

        for (int i = 0; i < N; i++) {
            if(arr[i]%M==0){
                num+=arr[i]/M;
            }else{
                num+=(arr[i]/M+1);
            }
        }

        System.out.println(num*M);

    }
}
