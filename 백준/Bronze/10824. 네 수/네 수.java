

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        String C = st.nextToken();
        String D = st.nextToken();

        long A1 =  Long.parseLong(A+B);
        long A2 =  Long.parseLong(C+D);

        StringBuilder sb  =new StringBuilder();
        sb.append(A1+A2);
        System.out.println(sb);
    }
}
