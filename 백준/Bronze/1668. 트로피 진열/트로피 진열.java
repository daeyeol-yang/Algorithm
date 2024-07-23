

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(br.readLine());

        }


        int count =0;
        int countR =0;
        int min=0;
        for (int i = 0; i < N; i++) {
           if(arr[i]>min){
               count++;
           }
           min=Math.max(arr[i],min);
        }
        min=0;
        for (int i = N-1; i >=0; i--) {
            if(arr[i]>min){
                countR++;
            }
            min=Math.max(arr[i],min);
        }

        System.out.println(count);
        System.out.println(countR);


    }
}
