

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int box = Integer.parseInt(st.nextToken());
        int book = Integer.parseInt(st.nextToken());
        int[] arrBook  = new int[book];
        int[] arrBox  = new int[box];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrBox.length; i++) {
            arrBox[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrBook.length; i++) {
            arrBook[i] = Integer.parseInt(st.nextToken());
        }

        int boxNum=0;
        int sum=0;
        for (int i = 0; i < arrBook.length; i++) {
            while (true) {
                if (arrBook[i] <= arrBox[boxNum]) {
                    arrBox[boxNum] -= arrBook[i];
                    break;
                }else{
                    boxNum++;
                }
            }
        }

        for (int i = 0; i < arrBox.length; i++) {
            sum+=arrBox[i];
        }
        System.out.println(sum);

    }
}
