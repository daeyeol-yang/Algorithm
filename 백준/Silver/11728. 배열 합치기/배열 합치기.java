

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size1 = Integer.parseInt(st.nextToken());
        int size2 = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] arr1 = new int[size1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size1; i++) {
            arr1[i]= Integer.parseInt(st.nextToken());
            arrayList.add(arr1[i]);
        }
        int[] arr2 = new int[size2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size2; i++) {
            arr2[i]= Integer.parseInt(st.nextToken());
            arrayList.add(arr2[i]);
        }

        Collections.sort(arrayList);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i)).append(" ");
        }

        System.out.println(sb);



    }
}
