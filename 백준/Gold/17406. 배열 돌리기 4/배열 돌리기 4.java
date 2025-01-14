

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] arr, original;
    static boolean[] visited;
    static ArrayList<int[]> operations = new ArrayList<>();
    static int[] order;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        original = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                original[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            operations.add(new int[]{r - 1, c - 1, s});
        }

        visited = new boolean[K];
        order = new int[K];

        permute(0);

        System.out.println(minValue);
    }

    // 순열 생성
    static void permute(int depth) {
        if (depth == K) {
            applyOperations();
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                permute(depth + 1);
                visited[i] = false;
            }
        }
    }

    // 주어진 순열대로 연산 적용
    static void applyOperations() {
        copyArray();

        for (int idx : order) {
            int[] op = operations.get(idx);
            rotate(op[0], op[1], op[2]);
        }

        calculateMinValue();
    }

    // 배열 복사
    static void copyArray() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, arr[i], 0, M);
        }
    }

    // 배열 회전
    static void rotate(int r, int c, int s) {
        for (int layer = 1; layer <= s; layer++) {
            int top = r - layer;
            int left = c - layer;
            int bottom = r + layer;
            int right = c + layer;

            int temp = arr[top][left];

            // 상 -> 하
            for (int i = top; i < bottom; i++) {
                arr[i][left] = arr[i + 1][left];
            }

            // 좌 -> 우
            for (int i = left; i < right; i++) {
                arr[bottom][i] = arr[bottom][i + 1];
            }

            // 하 -> 상
            for (int i = bottom; i > top; i--) {
                arr[i][right] = arr[i - 1][right];
            }

            // 우 -> 좌
            for (int i = right; i > left + 1; i--) {
                arr[top][i] = arr[top][i - 1];
            }

            arr[top][left + 1] = temp;
        }
    }

    // 최소값 계산
    static void calculateMinValue() {
        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            for (int j = 0; j < M; j++) {
                rowSum += arr[i][j];
            }
            minValue = Math.min(minValue, rowSum);
        }
    }
}
