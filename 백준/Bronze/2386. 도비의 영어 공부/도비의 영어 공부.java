

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String temp = br.readLine();
            temp = temp.toLowerCase();

            if(temp.equals("#")){
                break;
            }

            char c = temp.charAt(0);




            sb.append(c).append(" ");
            int count =0;
            for (int i = 1; i < temp.length(); i++) {

                if(temp.charAt(i)==c){
                    count++;
                }

            }

            sb.append(count).append('\n');



        }

        System.out.println(sb);
    }
}
