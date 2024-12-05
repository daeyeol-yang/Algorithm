

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        // 배열 값 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전 수행
        for (int i = 0; i < R; i++) {
            arr = rotate(arr);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // 반시계 방향으로 한 번 회전하는 함수
    public static int[][] rotate(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int layers = Math.min(N, M) / 2;  // 회전할 레이어 수

        // 각 레이어별로 회전 처리
        for (int layer = 0; layer < layers; layer++) {
            int top = layer;
            int bottom = N - layer - 1;
            int left = layer;
            int right = M - layer - 1;

            // 상단, 우측, 하단, 좌측 원소들을 순차적으로 이동
            int temp = arr[top][left]; // 첫 번째 원소 저장

            // 상단 왼쪽 -> 오른쪽으로 이동
            for (int i = left; i < right; i++) {
                arr[top][i] = arr[top][i + 1];
            }

            // 우측 위 -> 아래로 이동
            for (int i = top; i < bottom; i++) {
                arr[i][right] = arr[i + 1][right];
            }

            // 하단 오른쪽 -> 왼쪽으로 이동
            for (int i = right; i > left; i--) {
                arr[bottom][i] = arr[bottom][i - 1];
            }

            // 좌측 아래 -> 위로 이동
            for (int i = bottom; i > top; i--) {
                arr[i][left] = arr[i - 1][left];
            }

            // 첫 번째 원소를 마지막에 넣기
            arr[top + 1][left] = temp;
        }

        return arr;
    }
}
