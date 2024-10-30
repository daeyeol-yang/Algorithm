

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        
        int testCase = Integer.parseInt(br.readLine());

        int start = 0;
        int last = start+size;

        int count=0;

        for (int i = 0; i < testCase; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x>last){
                int countRight = x- last;
                count += countRight;

                start += countRight;
                last = x;

            }

            if(x<=start){
                int countLeft = start - x+1;
                count += countLeft;

                last -= countLeft;
                start = x-1;

            }



        }

        System.out.println(count);
        

    }
}
