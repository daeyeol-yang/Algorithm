

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();

        //((L+O) × (L+V) × (L+E) × (O+V) × (O+E) × (V+E)) mod 100

        for (int i = 0; i < N; i++) {
            String name1 = br.readLine();

            int L = 0;
            int O = 0;
            int V = 0;
            int E = 0;

            for (int j = 0; j < name1.length(); j++) {
                if (name1.charAt(j) == 'L') {
                    L++;
                }
                if (name1.charAt(j) == 'O') {
                    O++;
                }
                if (name1.charAt(j) == 'V') {
                    V++;
                }
                if (name1.charAt(j) == 'E') {
                    E++;
                }
            }

            for (int j = 0; j < name.length(); j++) {
                if (name.charAt(j) == 'L') {
                    L++;
                }
                if (name.charAt(j) == 'O') {
                    O++;
                }
                if (name.charAt(j) == 'V') {
                    V++;
                }
                if (name.charAt(j) == 'E') {
                    E++;
                }
            }

            hashMap.put(name1, ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100);
        }

        ArrayList<String> arrayList = new ArrayList<>(hashMap.keySet());

        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (hashMap.get(o1).equals(hashMap.get(o2))) {
                    return o1.compareTo(o2);
                } else {
                    return hashMap.get(o2).compareTo(hashMap.get(o1));
                }


            }
        });




        System.out.println(arrayList.get(0));
    }
}

