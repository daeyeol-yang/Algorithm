

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int size = s.length();

        for (int i = 0; i < size/2; i++) {
            if(s.charAt(i)!=s.charAt(size-1-i)){
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(1);
    }
}
