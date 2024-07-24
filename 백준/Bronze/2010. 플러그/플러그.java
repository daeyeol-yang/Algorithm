

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sol =1;
        for (int i = 0; i < N; i++) {
            int count = Integer.parseInt(br.readLine());
            sol--;
            sol+=count;

        }

        System.out.println(sol);
    }
}
