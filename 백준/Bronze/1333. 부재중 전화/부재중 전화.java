

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int totalDuration = N * L + (N - 1) * 5+D; // 전체 재생 시간
        boolean[] arr = new boolean[totalDuration + 1]; // 벨소리가 울리는 시간을 표시하는 배열

        // D초 간격으로 벨소리가 울리는 시간 표시
        for (int i = 0; i <= totalDuration; i += D) {
            arr[i] = true;
        }

        // 노래 재생 시간 표시
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < L; j++) {
                arr[i * (L + 5) + j] = false; // 노래 재생 시간 동안은 벨소리가 울리지 않음
            }
        }

        int result = -1;
        // 벨소리가 처음으로 울리는 시간을 찾음
        for (int i = 0; i <= totalDuration; i++) {
            if (arr[i]) {
                result = i;
                break;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
