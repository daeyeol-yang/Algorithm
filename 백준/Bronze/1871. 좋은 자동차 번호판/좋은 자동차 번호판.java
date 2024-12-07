
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
            StringTokenizer st = new StringTokenizer(br.readLine(),"-");
            String temp1 = st.nextToken();
            int tempSum =0;
            for (int j = 0; j < temp1.length(); j++) {
                tempSum += (temp1.charAt(j)-'A')*Math.pow(26,temp1.length()-1-j);


            }


            if(Math.abs(tempSum-Integer.parseInt(st.nextToken()))>100){
                sb.append("not nice").append('\n');
            }else{
                sb.append("nice").append('\n');
            }


        }

        System.out.println(sb);
    }
}
