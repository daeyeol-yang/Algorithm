

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][5];

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();


        StringTokenizer st = new StringTokenizer(br.readLine());

        int mp = Integer.parseInt(st.nextToken());
        int mf = Integer.parseInt(st.nextToken());
        int ms = Integer.parseInt(st.nextToken());
        int mv = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < (1<<N); i++) {

            ArrayList<Integer> shopping = new ArrayList<>();
            int tempMp =0;
            int tempMf =0;
            int tempMs =0;
            int tempMv =0;
            int tempSum =0;
            for (int j = 0; j < N; j++) {
                if((i & (1<<j))!=0){
                    shopping.add(j+1);
                    tempMp+=arr[j][0];
                    tempMf+=arr[j][1];
                    tempMs+=arr[j][2];
                    tempMv+=arr[j][3];
                    tempSum+=arr[j][4];

                }
            }

            if(tempMp>=mp&&tempMf>=mf&&tempMs>=ms&&tempMv>=mv){
                if(sum>tempSum){
                    sum = tempSum;
                    arrayLists.clear();
                    arrayLists.add(shopping);
                } else if(sum == tempSum){
                    arrayLists.add(shopping);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        if(sum == Integer.MAX_VALUE){
            sb.append(-1).append('\n');
        }else{
            Collections.sort(arrayLists, (a1, a2) -> {
                for (int i = 0; i < Math.min(a1.size(), a2.size()); i++) {
                    if (!a1.get(i).equals(a2.get(i))) {
                        return Integer.compare(a1.get(i), a2.get(i));
                    }
                }
                return Integer.compare(a1.size(), a2.size());
            });
            sb.append(sum).append('\n');

            for(int x : arrayLists.get(0)){
                sb.append(x).append(" ");
            }
        }
        System.out.println(sb);


    }
}
