

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<int[]> arrayList;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        go(N,r,0);

        Collections.sort(arrayList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                for (int i = 0; i < o1.length; i++) {
                    if(Integer.compare(o1[i],o2[i])==0){
                        continue;
                    }
                    return Integer.compare(o1[i],o2[i]);
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < r; j++) {
                sb.append(arrayList.get(i)[j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void go(int N,int R, int depth){
        if(R==depth){
            arrayList.add(arr.clone());
            return;
        }

        for (int i = depth; i <N ; i++) {
            swap(i,depth);
            go(N,R,depth+1);
            swap(i,depth);
        }
    }

    public static void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
