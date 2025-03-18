

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static int N;
    static int M;
    static int[] map;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N];


        for(int i =0 ; i< N ; i++) {
            map[i]= Integer.parseInt(br.readLine());
        }

        Arrays.sort(map);


        int max = 1000000000;
        int min = 1;
        int mid =0;
        int result =0;

        while(min <= max) {

            mid = (min + max)/2;
            //System.out.println(mid);
            if(check(mid)) {
                result = mid;
                min = mid+1;
            }else {
                max = mid-1;
            }


        }
        System.out.println(result);


    }

    public static boolean check(int mid) {

        int count =1;

        int gizun = map[0];

        for(int i =0 ; i<N-1 ; i++) {
            if((gizun+mid)<=map[i+1]) {
                gizun = map[i+1];
                count++;
            }

        }
        //System.out.println("mid"+mid+"count: "+count);

        return count>=M;


    }
}
