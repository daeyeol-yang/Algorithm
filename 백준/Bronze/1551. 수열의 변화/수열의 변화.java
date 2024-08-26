

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());
        int num  = Integer.parseInt(st.nextToken());


        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine(),",");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st1.nextToken()));
        }
        ArrayList<Integer> list1;

        for (int i = 0; i < num; i++) {

            int size = list.size();
            list1=new ArrayList<>();
            for (int j = 0; j < size-1; j++) {
                list1.add(list.get(j+1)-list.get(j));
            }

            list=list1;

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i!=list.size()-1){
                sb.append(",");
            }
        }


        System.out.println(sb);

    }
}
