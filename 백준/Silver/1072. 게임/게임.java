

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        long low =0;
        long high = 1000000000;

        long Z = Y * 100L / X;
        long sol = -1;

        while(low<=high){
            long mid = (low+high)/2;

            if((Y+mid)*100/(X + mid)>Z){
                high = mid -1;
                sol = mid;
            }else{
                low = mid+1;
            }




        }

        System.out.println(sol);
    }
}
