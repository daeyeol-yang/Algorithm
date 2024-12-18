

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String p = st.nextToken();
            int time =0;

            for (int j = 0; j < s.length(); j++) {
                int index = s.indexOf(p,j);

                if(index!=j){
                    time++;
                }else{
                    j = index+p.length()-1;
                    time++;

                }
            }
            System.out.println(time);
        }
    }
}
