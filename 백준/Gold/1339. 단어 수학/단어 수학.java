

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] temp = new String[N];
        int[] arr = new int[26];
        for (int i = 0; i < N; i++) {
            temp[i] = br.readLine();
            for (int j = temp[i].length() - 1; j >= 0; j--) {
                arr[temp[i].charAt(j) - 'A'] += Math.pow(10,temp[i].length()- j - 1);
            }
        }

        Arrays.sort(arr);

        int i =arr.length-1;
        int num = 9;
        int sum = 0;
        while (arr[i] != 0) {
            sum += arr[i] * num;
            num--;
            i--;
        }

        System.out.println(sum);
    }
}
