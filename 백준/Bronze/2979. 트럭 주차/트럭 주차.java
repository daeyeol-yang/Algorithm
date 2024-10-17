

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] map = new int[3][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int size =0;

        for (int i = 0; i < 3; i++) {
            size = Math.max(map[i][1],size);
        }

        int[] sol = new int[size + 1];

        for (int i = 0; i < 3; i++) {
            for (int j = map[i][0]; j < map[i][1]; j++) {
                sol[j]++;
            }
        }



        int sum = 0;

        for (int i = 1; i < sol.length; i++) {
            sum += arr[sol[i]]*sol[i];
        }

        System.out.println(sum);



    }
}
