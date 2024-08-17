

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        StringBuilder sb = new StringBuilder();
        while((n=Integer.parseInt(br.readLine()))!=0){
            String[] arr = new String[n];
            String[] copy = new String[n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                arr[i]= s.toLowerCase();
                copy[i] = s;
            }
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                if(arr[0].equals(copy[i].toLowerCase())){

                    sb.append(copy[i]).append('\n');
                }
            }

        }

        System.out.println(sb);
    }
}
