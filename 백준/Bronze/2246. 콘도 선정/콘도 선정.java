

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());

        }

        int count=0;


        for (int i = 0; i < N; i++) {

            boolean check = true;

            for (int j = 0; j < N; j++) {
                if(i==j){
                    continue;
                }
                if(arr[i][0]>arr[j][0]){
                    if(arr[i][1]>=arr[j][1]){
                        check=false;
                    }
                }

                if(arr[i][1]>arr[j][1]){
                    if(arr[i][0]>=arr[j][0]){
                        check=false;
                    }
                }

            }
            if(check){
                count++;
            }
        }

        System.out.println(count);
    }
}
