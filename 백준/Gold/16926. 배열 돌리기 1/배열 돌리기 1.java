

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());


        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }




        for (int i = 0; i < R; i++) {
            arr = sol(arr);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                sb.append(arr[i][j]).append(" ");

            }
            sb.append('\n');

        }

        System.out.println(sb);
    }



    public static int[][] sol(int[][] arr){

        int sero = arr.length;
        int garo = arr[0].length;

        int index = (Math.min(sero,garo))/2;



        for (int i = 0; i < index; i++) {

            int top = i;
            int bottom = sero-i-1;
            int left = i;
            int right = garo-i-1;

            int temp = arr[i][i];

//            for (int j = 1; j <=garo-2*i-1 ; j++) {
//                arr[top][j+i-1] = arr[top][j+i];
//            }

            for (int j = left; j <right ; j++) {
                arr[top][j] = arr[top][j+1];
            }

//            for (int j = 0; j < sero-2*i-1 ; j++) {
//                arr[j+i][garo-i-1] = arr[j+i+1][garo-i-1];
//            }

            for (int j = top; j < bottom; j++) {
                arr[j][right] = arr[j+1][right];
            }

//            for (int j = garo-2*i-2; j >=0 ; j--) {
//                arr[sero-1-i][j+i+1] = arr[sero-1-i][j+i];
//            }

            for (int j = right; j >left ; j--) {
                arr[bottom][j] = arr[bottom][j-1];
            }

//            for (int j = sero-2*i-2; j >=i ; j--) {
//                arr[j+1+i][i] = arr[j+i][i];
//            }

            for (int j = bottom; j >top+1 ; j--) {
                arr[j][left] = arr[j-1][left];
            }

            arr[1+i][i] = temp;
        }



        return arr;
    }

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


