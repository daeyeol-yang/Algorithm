

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){

            StringTokenizer st = new StringTokenizer(br.readLine());


            int N1 = Integer.parseInt(st.nextToken());
            int N2 = Integer.parseInt(st.nextToken());
            
            if(N1==0&&N2==0){
                break;
            }
            if(N1>N2){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
