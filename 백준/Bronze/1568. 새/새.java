

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = N;

        int time =0;
        int i=0;
        while (N>0){
            time++;
            i++;
            if(N<i){
                i=1;
            }
            N-=i;
        }

        System.out.println(time);

    }
}
