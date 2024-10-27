

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s,":");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int C = gcd(A,B);
        StringBuilder sb = new StringBuilder();
        sb.append(A/C).append(":").append(B/C);
        System.out.println(sb);

    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }

        return gcd(b,a%b);
    }
}
