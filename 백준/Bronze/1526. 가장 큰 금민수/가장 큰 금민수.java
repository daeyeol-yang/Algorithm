

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = N; i >0 ; i--) {
            if(isCheck(i)){
                sb.append(i);
                break;
            }
        }

        System.out.println(sb);

    }

    public static boolean isCheck(int N){
        while (N>0){
            int num = N%10;
            if(!(num==4||num==7)){
                return false;
            }
            N/=10;
        }
        return true;



    }

}
