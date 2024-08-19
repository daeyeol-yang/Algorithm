
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        //int N = Integer.parseInt(br.readLine());

        BigInteger sol = new BigInteger("0");
        for (int i = 1; i <N ; i++) {
            sol=sol.add(BigInteger.valueOf(i*N+i));

        }

        System.out.println(sol.toString());
    }
}
