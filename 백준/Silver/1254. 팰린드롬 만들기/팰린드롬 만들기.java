

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int sol =0;
        for (int i = s.length()-1; i >=0 ; i--) {
            String temp = s.substring(i);
            if(check(temp)){
               sol = temp.length()+(s.length()-temp.length())*2;
            }

        }
        
            System.out.println(sol);
       




    }

    public static boolean check(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
