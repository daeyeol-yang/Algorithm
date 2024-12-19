

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        s=s.replaceAll("pi",".");
        s=s.replaceAll("ka",".");
        s= s.replaceAll("chu",".");

       // System.out.println(s);




        boolean check = false;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='.'){
                check = true;
                break;
            }
        }


        if(check){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }
}
