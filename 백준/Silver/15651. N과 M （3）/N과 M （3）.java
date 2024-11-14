

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[R];

        go(N,R,0);
        System.out.println(sb);
    }

    public static void go(int N,int R, int depth){
        if(depth==R){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <=N ; i++) {
            arr[depth] = i;
            go(N,R,depth+1);
        }
    }
}
