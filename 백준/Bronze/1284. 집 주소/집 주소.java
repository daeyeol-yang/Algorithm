

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String temp = br.readLine();

            if (temp.equals("0")){
                break;
            }


            int num =0;

            for (int i = 0; i < temp.length(); i++) {
                int n = temp.charAt(i)-'0';

                if(n==1){
                    num+=2;
                }else if(n==0){
                    num +=4;
                }else{
                    num+=3;
                }

            }

            num+=temp.length()+1;

            System.out.println(num);

        }
    }
}
