

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr, sol;

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sol = new int[R];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        go(N,R,0);

        System.out.println(sb);
    }

    public static void go(int N, int R, int depth){
        if(depth==R){
            for(int num : sol){
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        int before = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i]!=before){
                sol[depth] = arr[i];
                before= arr[i];
                go(N,R,depth+1);
            }
        }
    }
}
