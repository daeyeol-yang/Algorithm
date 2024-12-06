

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];



        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < Math.min(N,M)/2; i++) {
            arr = rotate(arr,i);
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

    public static int[][] rotate(int[][] arr,int layer){
        int sero = arr.length;
        int garo = arr[0].length;
        
            int top = layer;

            int bottom = sero - layer -1;

            int left = layer;

            int right = garo - layer -1;

            int size = R%((sero-2*layer+garo-2*layer)*2-4);

        for (int r = 0; r <size ; r++) {


            int temp = arr[top][left];

            for (int i = left; i < right; i++) {
                arr[top][i] = arr[top][i + 1];
            }

            for (int i = top; i < bottom; i++) {
                arr[i][right] = arr[i + 1][right];
            }

            for (int i = right; i > left; i--) {
                arr[bottom][i] = arr[bottom][i - 1];
            }


            for (int i = bottom; i > top + 1; i--) {
                arr[i][left] = arr[i - 1][left];
            }

            arr[top + 1][left] = temp;
        }




        return arr;
    }


}
