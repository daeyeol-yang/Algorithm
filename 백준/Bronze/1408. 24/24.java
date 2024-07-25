

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] a1  = s.split(":");
        String s1 = br.readLine();
        String[] a2 = s1.split(":");
        int now = Integer.parseInt(a1[0])*3600 + Integer.parseInt(a1[1])*60 + Integer.parseInt(a1[2]);
        int start = Integer.parseInt(a2[0])*3600 + Integer.parseInt(a2[1])*60 + Integer.parseInt(a2[2]);

        int sol=0;
        if(now>start){
            sol=24*3600+start-now;
        }else{
            sol=start-now;
        }

        System.out.format("%02d:%02d:%02d",(sol/3600), (sol/60)%60,sol%60);

    }
}
