
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        boolean [] arr = new boolean[101];
        int count =0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(arr[num]){
                count++;
            }else{
                arr[num]=true;
            }
        }

        System.out.println(count);


    }
}
