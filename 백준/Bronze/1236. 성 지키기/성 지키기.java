

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j <M; j++) {
                arr[i][j]=input.charAt(j);
            }
        }

        int sero =0;
        int garo =0;

        boolean checkSero = false;
        boolean checkGaro = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j]=='X'){
                    checkSero=true;
                    break;
                }
            }
            if(!checkSero){
                sero++;
            }
            checkSero=false;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[j][i]=='X'){
                    checkGaro=true;
                    break;
                }
            }
            if(!checkGaro){
                garo++;
            }
            checkGaro=false;
        }

        System.out.println(Math.max(garo,sero));
    }
}
