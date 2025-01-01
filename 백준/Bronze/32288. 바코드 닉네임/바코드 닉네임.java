

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);

            if(c=='I'){
                sb.append('i');
            }else{
                sb.append('L');
            }
        }
        System.out.println(sb);
    }
}
