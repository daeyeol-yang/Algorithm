

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger S = new BigInteger("0");
            for (int j = 0; j < N; j++) {
                BigInteger s1 = new BigInteger(br.readLine());
                S=S.add(s1);
            }
            if(S.compareTo(BigInteger.ZERO)==1){
                sb.append("+").append('\n');
            }else if(S.compareTo(BigInteger.ZERO)==0){
                sb.append(0).append('\n');
            }else{
                sb.append("-").append('\n');
            }

        }
        System.out.println(sb);
    }
}
