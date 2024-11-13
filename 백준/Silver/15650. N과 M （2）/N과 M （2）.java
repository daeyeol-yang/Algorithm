

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int n,r;

    public static ArrayList<Integer> arrayList;


    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();




        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }


        combi(0);

    }

    public static void combi(int start){
        if(r == arrayList.size()){
            for(int num : arrayList){
                System.out.print(num +" ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <n; i++) {
            arrayList.add(arr[i]);
            combi(i+1);
            arrayList.remove(Integer.valueOf(arr[i]));
        }

    }
}
