import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        long S[] = new long[N+1]; //StringTokenizer로 받는 이유 S[0]이 없어도 다음것을 불러오기 때문에!!
        st= new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i]=S[i-1]+Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < Q; i++) {
            st=new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            System.out.println(S[num2]-S[num1-1]);

        }


    }
}
