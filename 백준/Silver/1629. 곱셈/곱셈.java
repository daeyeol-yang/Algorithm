

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());
        Long C = Long.parseLong(st.nextToken());
        System.out.println(sol(A,B,C));



    }

    public static Long sol(Long a, Long b , Long c){

        if(b==1){

            return a%c;
        }

        long temp = sol(a,b/2,c);
        long temp1 = temp%c *temp%c;


        if(b%2!=0){
            temp1 = temp%c*temp%c*a%c;
        }
        return temp1;

    }
}
