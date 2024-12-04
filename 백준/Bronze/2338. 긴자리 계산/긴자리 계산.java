

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger bg = new BigInteger(br.readLine());
        BigInteger bg1 = new BigInteger(br.readLine());

        System.out.println(bg.add(bg1));
        System.out.println(bg.subtract(bg1));
        System.out.println(bg.multiply(bg1));
    }
}
