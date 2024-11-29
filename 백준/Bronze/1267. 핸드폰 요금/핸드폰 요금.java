

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int Y = 0;
        int M = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken())+1;
            Y += ((arr[i]%30==0?arr[i]/30:arr[i]/30+1))*10;
            M += ((arr[i]%60==0?arr[i]/60:arr[i]/60+1))*15;
        }
        StringBuilder sb = new StringBuilder();

        if(Y<M){
            sb.append("Y").append(" ").append(Y);
        }else if(Y==M){
            sb.append("Y").append(" ").append("M").append(" ").append(Y);
        }else{
            sb.append("M").append(" ").append(M);

        }

        System.out.println(sb);


    }
}
