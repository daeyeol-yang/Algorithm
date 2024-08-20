
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(s1,":");
            int start = Integer.parseInt(st1.nextToken())*10000+Integer.parseInt(st1.nextToken())*100+Integer.parseInt(
                    st1.nextToken());
            st1 = new StringTokenizer(s2,":");
            int end = Integer.parseInt(st1.nextToken())*10000+Integer.parseInt(st1.nextToken())*100+Integer.parseInt(
                    st1.nextToken());

            int count=0;

            if(end<start){
                for (int j = start; j < 240000 ; j++) {
                    if(j%100>59){
                        continue;
                    }
                    if(j%10000>5959){
                        continue;
                    }
                    if(isCheck(j)){
                        count++;
                    }
                }

                for (int j = 0; j <= end ; j++) {
                    if(j%100>59){
                        continue;
                    }
                    if(j%10000>5959){
                        continue;
                    }
                    if(isCheck(j)){
                        count++;
                    }
                }
            }else{
                for (int j = start; j <= end ; j++) {
                    if(j%100>59){
                        continue;
                    }
                    if(j%10000>5959){
                        continue;
                    }
                    if(isCheck(j)){
                        count++;
                    }
                }
            }


            System.out.println(count);


        }
    }

    public static boolean isCheck(int N){
        if(N%3==0){
            return true;
        }
        return false;
    }
}
