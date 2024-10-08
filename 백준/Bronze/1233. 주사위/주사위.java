

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = a+b+c;

        int[] arr = new int[sum+1];

        for (int i = 1; i <=a ; i++) {
            for (int j = 1; j <=b ; j++) {
                for (int k = 1; k <=c ; k++) {
                    arr[i+j+k]++;
                }
            }
        }

        int max=0;
        int sol=0;
        for (int i = arr.length-1; i >0; i--) {
            if(arr[i]>=max){
                max=arr[i];
                sol=i;
            }
        }


        System.out.println(sol);
    }
}
