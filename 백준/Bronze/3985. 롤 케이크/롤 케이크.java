

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[size];
        int sol1 =0;
        int sol2 =0;
        int eMax  = 0;
        int mSum =0;
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int sum=0;
            int size1  = end-start+1;
            if(size1>eMax){
                sol1=i+1;
                eMax=size1;
            }

            for (int j = start-1; j <end ; j++) {
                if(!arr[j]){
                    arr[j]=true;
                    sum++;
                }
            }
            if(sum>mSum){
                sol2 = i+1;
                mSum=sum;
            }
        }

        System.out.println(sol1);
        System.out.println(sol2);
    }
}
