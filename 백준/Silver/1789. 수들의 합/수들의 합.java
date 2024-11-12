import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long answer =0;

            while(true){

                answer+=1;
                if(answer*(answer+1)>N*2){
                    break;
                }
            }
            System.out.println(answer-1);

    }
}
