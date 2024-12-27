
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("Case ").append(i+1).append(":").append(" ");
            String temp = br.readLine();

            temp = temp.toLowerCase();


            int[] arr = new int[26];

            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);

                if('a'<=c&&c<='z'){
                    arr[temp.charAt(j)-'a']++;

                }
            }

            Arrays.sort(arr);


            int sol = arr[0];

            if(sol==0){
                sb.append("Not a pangram").append('\n');
            } else if (sol==1) {
                sb.append("Pangram!").append('\n');
            } else if (sol==2) {
                sb.append("Double pangram!!").append('\n');
            } else if(sol==3){
                sb.append("Triple pangram!!!").append('\n');
            }



        }
        System.out.println(sb);
    }
}
