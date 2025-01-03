

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        map = new boolean[1000001];
        isPrime();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int count =0;

            for (int j = 2; j <= n/2; j++) {

                if(!map[j]){
                    if(!map[n-j]){
                        count++;
                    }
                }

            }
            sb.append(count).append('\n');


        }
        System.out.println(sb);
    }

    public static void isPrime(){

        map[0] = true;
        map[1] = true;

        for (int i = 2; i < map.length ; i++) {

            if(map[i]==false){

                for (int j = 2; j*i < map.length ; j++) {
                    map[i*j] = true;
                }
            }

        }
    }
}
