

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;

    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[r];

        visited = new boolean[n];

        go(n,r,0,0);
    }

    public static void go(int n,int r,int depth,int start){
        if(depth==r){
            for(int num : arr){
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n ; i++) {
            if(!visited[i-1]&&i>start){
                visited[i-1]=true;
                arr[depth] = i;
                go(n,r,depth+1,i);
                visited[i-1]=false;
            }
        }
    }
}
