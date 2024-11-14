

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N,R;

    public static int[] arr;

    public static ArrayList<Integer> arrayList;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        R = Integer.parseInt(st.nextToken());

        arr = new int[N];
        arrayList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        go(0);

        System.out.println(sb);
    }

    public static void go(int start){
        if(arrayList.size()==R){
            for(int num : arrayList){
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <N ; i++) {
            arrayList.add(arr[i]);
            go(i+1);
            arrayList.remove(Integer.valueOf(arr[i]));
        }
    }
}
