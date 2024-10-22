

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
            int test1 = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < test1; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int test2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < test2; j++) {
                int num = Integer.parseInt(st.nextToken());

                if(set.contains(num)){
                    sb.append(1).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }




        }
        System.out.println(sb);
    }
}
