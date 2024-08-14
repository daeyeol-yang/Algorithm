

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),":");

        int si = Integer.parseInt(st.nextToken());
        int bun = Integer.parseInt(st.nextToken());
        int cho = Integer.parseInt(st.nextToken());

        int siga =0;
        if(0<si&&si<13){
            siga++;
        }
        if(0<bun&&bun<13){
            siga++;
        }
        if(0<cho&&cho<13){
            siga++;
        }

        if(si>59||bun>59||cho>59){
            System.out.println(0);
        }else{

            System.out.println(siga*2);
        }



    }
}
