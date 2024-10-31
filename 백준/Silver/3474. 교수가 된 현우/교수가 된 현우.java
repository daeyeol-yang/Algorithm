

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int count =0;
//            for (int j = 1; j <= num; j++) {
//                for (int k = 5; k <=num ; k*=5) {
//                    if(j%k==0){
//                        count++;
//                    }
//
//                }
//            }

            for (int j = 5; j <=num ; j*=5) {
               count +=num/j;
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);


    }
}
