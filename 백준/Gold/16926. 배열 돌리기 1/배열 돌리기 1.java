

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // N 행
        int M = Integer.parseInt(st.nextToken());  // M 열
        int R = Integer.parseInt(st.nextToken());  // 회전 횟수

        int[][] arr = new int[N][M];

        // 배열 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전 R번
        for (int i = 0; i < R; i++) {
            arr = rotate(arr);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 배열 회전 메소드
    public static int[][] rotate(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int layers = Math.min(N, M) / 2;  // 레이어 수

        // 각 레이어별로 회전 수행
        for (int layer = 0; layer < layers; layer++) {
            // 레이어의 테두리를 1차원 리스트로 저장
            List<Integer> temp = new ArrayList<>();
            
            // 위쪽
            for (int j = layer; j < M - layer; j++) {
                temp.add(arr[layer][j]);
            }
            // 오른쪽
            for (int i = layer + 1; i < N - layer; i++) {
                temp.add(arr[i][M - layer - 1]);
            }
            // 아래쪽
            for (int j = M - layer - 2; j >= layer; j--) {
                temp.add(arr[N - layer - 1][j]);
            }
            // 왼쪽
            for (int i = N - layer - 2; i > layer; i--) {
                temp.add(arr[i][layer]);
            }

            // 회전: 반시계방향으로 한 칸씩 이동
            int size = temp.size();
            int[] rotated = new int[size];
            for (int i = 0; i < size; i++) {
                rotated[i] = temp.get((i + 1) % size);  // 반시계방향 회전
            }

            // 회전된 값을 배열에 다시 넣기
            int idx = 0;
            // 위쪽
            for (int j = layer; j < M - layer; j++) {
                arr[layer][j] = rotated[idx++];
            }
            // 오른쪽
            for (int i = layer + 1; i < N - layer; i++) {
                arr[i][M - layer - 1] = rotated[idx++];
            }
            // 아래쪽
            for (int j = M - layer - 2; j >= layer; j--) {
                arr[N - layer - 1][j] = rotated[idx++];
            }
            // 왼쪽
            for (int i = N - layer - 2; i > layer; i--) {
                arr[i][layer] = rotated[idx++];
            }
        }
        return arr;
    }
}
