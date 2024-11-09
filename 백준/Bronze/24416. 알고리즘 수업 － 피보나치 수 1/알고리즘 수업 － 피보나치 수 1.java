

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int count1;
    public static int count2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        fibo1(N);
        fibo(N);
        System.out.println(count1);
        System.out.println(count2);
    }

    public static int fibo1(int N){
        if(N==1||N==2){
            count1++;
            return 1;
        }

        return fibo1(N-1)+fibo1(N-2);
    }

    public static int fibo(int N){
        int [] fiboArray = new int[50];

        fiboArray[1]=1;
        fiboArray[2]=1;

        for (int i = 3; i <=N ; i++) {
            count2++;
            fiboArray[N] = fiboArray[N-1] + fiboArray[N-2];
        }

        return fiboArray[N];
    }
}
