import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int [] arr = new int[26];

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            int a = s.charAt(0)-'a';
            arr[a]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=5){
                sb.append((char)(i + 97));
            }
        }
        if(sb.length()==0){
            System.out.println("PREDAJA");
        }else{

            System.out.println(sb);
        }
    }
}
