

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sol = new int[N];

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int index =0;
            int count =0;
            while(true){

                if(count==num&&sol[index]==0){
                    sol[index] = i+1;
                    break;
                }

                if(sol[index]==0){
                    count++;
                }
                index++;

            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(sol[i]).append(" ");
        }



        System.out.println(sb);


    }
}
