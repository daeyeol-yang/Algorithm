
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();



        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(Solution(Integer.parseInt(s.substring(i,i+1))));
        }

        if(s.equals("0")){
            System.out.println(0);
        }else {


            while (true) {
                if (sb.indexOf("0") == 0) {
                    sb.deleteCharAt(0);
                } else {
                    break;
                }
            }

            System.out.println(sb);
        }



    }

    public static String Solution(int num){
        StringBuilder sb = new StringBuilder();
        while (num>0){
            sb.append(num%2);
            num/=2;
        }
        int size = 3- sb.length();

        for (int i = 0; i < size; i++) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }
}
