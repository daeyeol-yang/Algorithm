

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0,arr);

        System.out.println(max);
    }

    public static void go(int count, int[][] arr){
        if(count==5){
            solve(arr);
            return;
        }
        int size = arr.length;

        int[][] temp = new int[size][size];
        for (int i = 0; i < 4; i++) {
            temp = slide(arr);
            go(count+1,temp);
            arr = rotate(arr);

        }


    }

    public static int[][] slide(int[][] arr){
        int size = arr.length;
        int[][] temp = new int[size][size];

        for (int i = 0; i < size; i++) {
            int cnt =0;
            for (int j = 0; j < size; j++) {
                if(arr[i][j]==0){
                    continue;
                }

                if(temp[i][cnt]==0){
                    temp[i][cnt] = arr[i][j];
                } else if (temp[i][cnt] == arr[i][j]) {
                    temp[i][cnt]*=2;
                    cnt++;
                }else{
                    cnt++;
                    temp[i][cnt] = arr[i][j];
                }

            }
            
        }

        return temp;

    }

    public static void solve(int[][] arr){
        for (int i = 0; i < arr.length;i++){
            for (int j = 0; j < arr.length; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }

    }


    public static int[][] rotate(int[][] arr){
        int size = arr.length;

        int[][] temp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[i][j] = arr[size-j-1][i];
            }
        }

        return temp;

    }
}
