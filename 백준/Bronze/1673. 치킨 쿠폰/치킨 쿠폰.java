

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s= br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(s);

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int sum =0;

            int chicken=0;

            chicken+=N;

            sum+=N;
            while(true){
                if(sum<K){
                    break;
                }
                chicken+=sum/K;
                sum = sum%K+sum/K;

            }

            System.out.println(chicken);


        }

    }
}
