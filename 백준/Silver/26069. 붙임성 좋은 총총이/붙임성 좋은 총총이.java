

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set1 = new HashSet<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();
            if(name1.equals("ChongChong")||name2.equals("ChongChong")){
                set1.add(name1);
                set1.add(name2);
            }
            if(set1.contains(name1)|| set1.contains(name2)){
                set1.add(name1);
                set1.add(name2);
            }
        }

        System.out.println(set1.size());
    }
}
