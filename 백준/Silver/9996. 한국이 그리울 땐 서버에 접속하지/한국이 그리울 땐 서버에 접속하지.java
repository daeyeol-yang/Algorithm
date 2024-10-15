

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s,"*");
        String left = st.nextToken();
        String right = st.nextToken();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();


            if(left.length()+right.length()<=temp.length()){

                if (temp.substring(0, left.length()).equals(left) &&
                        temp.substring(temp.length() - right.length()).equals(right)) {
                    sb.append("DA").append('\n');
                } else {
                    sb.append("NE").append('\n');
                }
            }else{
                sb.append("NE").append('\n');
            }
        }

        System.out.println(sb);
    }
}
