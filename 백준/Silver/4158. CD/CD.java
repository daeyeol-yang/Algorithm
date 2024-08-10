

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[N];
            int[] arr2 = new int[M];

            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M; i++) {
                arr2[i] = Integer.parseInt(br.readLine());
            }

            int start1 = 0;
            int start2 = 0;
            int count = 0;

            while (start1 < N && start2 < M) {
                if (arr1[start1] == arr2[start2]) {
                    count++;
                    start1++;
                    start2++; // 여기서 두 포인터를 모두 증가시킵니다.
                } else if (arr1[start1] > arr2[start2]) {
                    start2++;
                } else {
                    start1++;
                }
            }
            System.out.println(count);
        }
    }
}
