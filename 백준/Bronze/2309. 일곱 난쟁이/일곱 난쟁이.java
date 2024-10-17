

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum =0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            arrayList.add(num);
            sum+=num;
        }
        int cha = sum-100;
        boolean check =false;

        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j <9 ; j++) {
                if(arrayList.get(i)+arrayList.get(j)==cha){
                    int num1 = arrayList.get(i);
                    int num2 = arrayList.get(j);

                    arrayList.remove(arrayList.indexOf(num1));
                    arrayList.remove(arrayList.indexOf(num2));
                    check = true;
                    break;
                }
            }
            if(check){
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(arrayList);

        for (int i = 0; i < 7; i++) {
            sb.append(arrayList.get(i)).append('\n');
        }

        System.out.println(sb);


    }

}
