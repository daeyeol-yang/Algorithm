

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("Scenario #").append(i+1).append(":").append('\n');


            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[3];

            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }


            Arrays.sort(arr);

            if(Math.pow(arr[2],2) == Math.pow(arr[0],2)+ Math.pow(arr[1],2)){
                sb.append("yes");
            }else{
                sb.append("no");
            }

            sb.append('\n');
            sb.append('\n');

        }

        System.out.println(sb);
    }
}
