

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(br.readLine());
        }

        int start =0;
        int end =0;
        int max =0;
        Arrays.sort(arr);

        while (end<N){

                if(arr[end]-arr[start]<5){
                    max = Math.max(max,end-start);
                    end++;
                }else{
                    start++;
                }




        }

        System.out.println(4-max);
    }
}
