

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int sol =0;

        for (int i = 0; i < count; i++) {
            sol = num1^num2;
            num1 = sol;
        }

        System.out.println(sol);
    }
}
