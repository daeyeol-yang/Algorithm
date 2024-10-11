

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            arrayList.add(digit);
            sum += digit;
        }

        if (arrayList.contains(0) && sum % 3 == 0) {
            StringBuilder sb = new StringBuilder();
            Collections.sort(arrayList, Collections.reverseOrder());
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i));
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }


    }
}
