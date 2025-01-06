

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String problem = br.readLine();
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();



        for (int i = 0; i < problem.length(); i++) {
            char c = problem.charAt(i);

            sb.append(c);

            if(sb.length()>=s.length() && sb.substring(sb.length()-s.length()).equals(s)){
                sb.delete(sb.length()-s.length(),sb.length());
            }

        }

        if(sb.toString().isEmpty()){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }
    }
}
