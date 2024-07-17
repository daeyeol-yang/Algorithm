

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int time =0;
        int init =m;
        boolean check = false;

        while (N>0){
            int prevM  = m;
            if(m+T<=M){
                m+=T;
                N--;
            }else{
                if(m-R<init){
                    m=init;
                }else{
                    m-=R;
                }
            }

            if(prevM==m){
                check=true;
                break;
            }

            time++;


        }
            if(check){
                System.out.println(-1);
            }else{

                System.out.println(time);
            }



    }
}
