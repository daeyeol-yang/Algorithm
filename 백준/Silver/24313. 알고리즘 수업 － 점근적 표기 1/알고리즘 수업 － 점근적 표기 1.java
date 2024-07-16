
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int a1 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int cha  = c-a;

        if(cha*n>=a1&&cha>=0){
            System.out.println(1);
        }else{
            System.out.println(0);
        }


    }
}
