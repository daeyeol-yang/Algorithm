

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();//숫자의 갯수가 100자리가 될 수 있으므로 int나 long 타입으로 받을 수 없다.


        int sum =0;
        for (int i = 0; i < N; i++) {
            sum+=s.charAt(i)-'0';
        }

        System.out.println(sum);


    }
}
