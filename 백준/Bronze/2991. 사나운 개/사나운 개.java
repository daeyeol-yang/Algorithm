

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[1005];

        int dog1Bark = Integer.parseInt(st.nextToken());
        int dog1Rest = Integer.parseInt(st.nextToken());
        int dog2Bark = Integer.parseInt(st.nextToken());
        int dog2Rest = Integer.parseInt(st.nextToken());



        int i =1;
        while (i<=999){

            for (int j = 0; j <dog1Bark ; j++) {
                arr[i+j]++;
            }

            i+=(dog1Bark+dog1Rest);

        }

        i=1;
        while (i<=999){

            for (int j = 0; j <dog2Bark ; j++) {
                arr[i+j]++;
            }

            i+=(dog2Bark+dog2Rest);

        }

        st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int N  = Integer.parseInt(st.nextToken());

        System.out.println(arr[P]);
        System.out.println(arr[M]);
        System.out.println(arr[N]);

        //System.out.println(Arrays.toString(arr));

    }
}
