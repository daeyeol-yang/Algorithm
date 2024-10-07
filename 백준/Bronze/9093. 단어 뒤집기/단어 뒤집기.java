

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
        StringTokenizer st= new StringTokenizer(br.readLine());
        int size = st.countTokens();
            for (int j = 0; j < size; j++) {
                sb.append(reverse(st.nextToken())).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static String reverse(String s){
        StringBuilder sb1 = new StringBuilder(s);
        return sb1.reverse().toString();
    }
}
