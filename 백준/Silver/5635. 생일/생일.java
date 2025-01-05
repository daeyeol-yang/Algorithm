


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<String[]> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] arr = new String[4];

            String name = st.nextToken();
            String day = st.nextToken();
            String month = st.nextToken();
            String year = st.nextToken();

            arr[0] = name;
            arr[1] = day;
            arr[2] = month;
            arr[3] = year;

            arrayList.add(arr);


        }

        Collections.sort(arrayList, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[3].equals(o2[3])) {

                    if (o1[2].equals(o2[2])) {

                        if (o1[1].equals(o2[1])) {

                        }

                        return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));

                    }

                    return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));

                }

                return Integer.compare(Integer.parseInt(o1[3]), Integer.parseInt(o2[3]));


            }
        });

        System.out.println(arrayList.get(N-1)[0]);
        System.out.println(arrayList.get(0)[0]);
    }
}
