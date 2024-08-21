

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        char[][] arr = {{'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},{'M','N','O'},{'P','Q','R','S'},{'T','U','V'},{'W','X','Y','Z'}};

        int time =0;
        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c==' '){
                time+=p;
            }else{
                for (int j = 0; j < arr.length; j++) {
                    for (int k = 0; k < arr[j].length; k++) {
                        if(arr[j][k]==c){
                            time+= p*(k+1) +isCheck(j,arr,prev);
                        }
                    }
                }
            }

            
            prev =c;

        }

        System.out.println(time);

    }

    public static int isCheck(int j , char[][] arr, char prev){
        for (int i = 0; i < arr[j].length; i++) {
            if(arr[j][i]==prev){
                return w;
            }
        }
        return 0;
    }
}
