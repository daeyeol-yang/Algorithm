

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
            // 각 레이어의 상하좌우 값을 구한다
            int top = layer;
            int bottom = N - layer - 1;
            int left = layer;
            int right = M - layer - 1;

            // 레이어의 원소들을 1차원 배열로 뽑아낸다
            int[] elements = new int[2 * (bottom - top + right - left)];

            int index = 0;

            // 상단 (왼쪽 -> 오른쪽)
            for (int i = left; i < right; i++) {
                elements[index++] = arr[top][i];
            }

            // 우측 (위 -> 아래)
            for (int i = top; i < bottom; i++) {
                elements[index++] = arr[i][right];
            }

            // 하단 (오른쪽 -> 왼쪽)
            for (int i = right; i > left; i--) {
                elements[index++] = arr[bottom][i];
            }

            // 좌측 (아래 -> 위)
            for (int i = bottom; i > top; i--) {
                elements[index++] = arr[i][left];
            }

            // 회전시킨 배열을 다시 2D 배열로 복원
            // 반시계 방향으로 회전: 1칸씩 이동
            int temp = elements[0];
            for (int i = 0; i < elements.length - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[elements.length - 1] = temp;

            index = 0;
            // 상단 (왼쪽 -> 오른쪽)
            for (int i = left; i < right; i++) {
                arr[top][i] = elements[index++];
            }

            // 우측 (위 -> 아래)
            for (int i = top; i < bottom; i++) {
                arr[i][right] = elements[index++];
            }

            // 하단 (오른쪽 -> 왼쪽)
            for (int i = right; i > left; i--) {
                arr[bottom][i] = elements[index++];
            }

            // 좌측 (아래 -> 위)
            for (int i = bottom; i > top; i--) {
                arr[i][left] = elements[index++];
            }
        }

        return arr;
    }
}
