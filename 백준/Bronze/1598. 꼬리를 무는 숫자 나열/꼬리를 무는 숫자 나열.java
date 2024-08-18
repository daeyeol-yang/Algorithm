

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int a1 = a%4==0?4:a%4;
        int b1 = b%4==0?4:b%4;
        int a2 = a%4!=0?a/4+1:a/4;
        int b2 = b%4!=0?b/4+1:b/4;

        System.out.println(Math.abs(a1-b1)+Math.abs(a2-b2));
    }
}
