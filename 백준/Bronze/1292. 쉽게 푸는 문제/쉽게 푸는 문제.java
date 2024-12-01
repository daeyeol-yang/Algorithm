

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long sol =0;

        int arr[] = new int[10001];
        int num =1;
        int count =0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = num;
            count++;
            if(count==num){
                count=0;
                num++;
            }
        }

        for (int i = start; i <=end ; i++) {
            sol+=arr[i];
        }

        System.out.println(sol);
    }
}
