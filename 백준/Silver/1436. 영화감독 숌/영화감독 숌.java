

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int solution =0;

        while (N>0){
            int num =0;
            while (true){

                if(String.valueOf(num).contains("666")){
                    N--;
                }

                if(N==0){
                    solution = num;
                    break;
                }

                num++;
            }


        }

        System.out.println(solution);
    }
}
