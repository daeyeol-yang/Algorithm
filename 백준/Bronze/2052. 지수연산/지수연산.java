import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      
        int N = Integer.parseInt(br.readLine());


        BigDecimal result = BigDecimal.ONE.divide(new BigDecimal(2).pow(N));


        System.out.println(result.stripTrailingZeros().toPlainString());
    }
}
