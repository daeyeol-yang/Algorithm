import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(bf.readLine());
        int M =Integer.parseInt(bf.readLine());

        int []array= new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            array[i]=Integer.parseInt(st.nextToken());

        }
        Arrays.sort(array);
        int count=0;
        int start=0;
        int last = N-1;
        while(last>start){
            if(array[start]+array[last]<M){
                start++;
            } else if (array[start]+array[last]>M) {
                last--;
            }else{
                count++;
                start++;
                last--;
            }
        }
        System.out.println(count);
    }
}
