

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int L = Integer.parseInt(st.nextToken());

        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arrayList.add(new int[]{start,end});


        }

        Collections.sort(arrayList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return Integer.compare(o1[1],o2[1]);
                }
                return Integer.compare(o1[0],o2[0]);
            }
        });

        int index =0;

        int sol =0;

        for (int i = 0; i < N; i++) {
            int sum =0;
            int[] temp = arrayList.get(i);
            if(index < temp[0]){

                sum =(temp[1] - temp[0])/L;

                if((temp[1] - temp[0]) % L !=0){
                    sum+=1;
                }

                index = temp[0] + sum*L;

            }else if( index <= temp[1] ){

                sum =(temp[1] - index)/L;

                if((temp[1] - index) % L !=0){
                    sum+=1;
                }

                index = index+sum*L;
            }

            sol += sum;

        }

        System.out.println(sol);

    }
}
