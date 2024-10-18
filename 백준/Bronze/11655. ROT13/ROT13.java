

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if('a'<=c&&c<='z') {
                c+=13;
                if(c>'z'){
                    c-=26;
                }
            }
            if('A'<=c && c <='Z'){
                c+=13;
                if(c>'Z'){
                    c-=26;
                }
            }
            sb.append(c);
        }

        System.out.println(sb);

    }
}
