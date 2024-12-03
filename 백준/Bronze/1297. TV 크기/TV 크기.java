

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double D = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());
        double W = Double.parseDouble(st.nextToken());



        int sol1 = (int) (Math.sqrt(Math.pow(D,2) / (Math.pow(H,2)+Math.pow(W,2)))*H);
        int sol2 = (int) (Math.sqrt(Math.pow(D,2) / (Math.pow(H,2)+Math.pow(W,2)))*W);


        StringBuilder sb = new StringBuilder();
        sb.append(sol1).append(" ").append(sol2);

        System.out.println(sb);
    }
}
