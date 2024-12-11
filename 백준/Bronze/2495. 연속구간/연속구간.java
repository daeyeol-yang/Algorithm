

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            String temp = br.readLine();

            char now = temp.charAt(0);
            int count =1;
            int sol = 0;
            for (int j = 1; j <temp.length() ; j++) {
                if(temp.charAt(j)==now){
                    count++;
                }else{
                    count=1;
                    now = temp.charAt(j);
                }
                sol = Math.max(sol,count);
            }
            System.out.println(sol);
        }
    }
}
