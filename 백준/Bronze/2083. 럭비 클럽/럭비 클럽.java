

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        while (!(input = br.readLine()).equals("# 0 0")){
            StringTokenizer st = new StringTokenizer(input);
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            sb.append(name).append(" ");
            if(age>17||weight>=80){
                sb.append("Senior");
            }else{
                sb.append("Junior");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
