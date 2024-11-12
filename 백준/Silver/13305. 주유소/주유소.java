

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] money = new int[N-1];
        int[] city = new int[N-1];

        StringTokenizer

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            min = Math.min(money[i],min);

        }

        int minIndex =0;
        for (int i = money.length-1; i >=0 ; i--) {
            if(money[i]==min){
                minIndex = i;
            }
        }



        int sum =0;

        for (int i = 0; i < minIndex; i++) {
                sum+=money[i]*city[i];
        }

        for (int i = minIndex; i <N-1 ; i++) {
            sum+=min*city[i];
        }

        System.out.println(sum);




    }
}
