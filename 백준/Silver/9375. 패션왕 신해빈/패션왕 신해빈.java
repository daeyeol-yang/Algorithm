

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int N1 = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < N1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String s = st.nextToken();
                hashMap.put(s,hashMap.getOrDefault(s,0)+1);

            }
            int sum =1;
            for(int num : hashMap.values()){
                sum*=(num+1);
            }
            sb.append(sum-1).append('\n');
        }
        System.out.println(sb);
        
    }
}
