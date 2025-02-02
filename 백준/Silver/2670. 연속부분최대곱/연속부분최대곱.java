

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        double max =0;

        for (int i = 0; i < N; i++) {
            double temp =1;
            for (int j = i; j < N ; j++) {
                temp *= arr[j];

                max = Math.max(temp,max);
            }
        }

        System.out.printf("%.3f",max);
    }
}
