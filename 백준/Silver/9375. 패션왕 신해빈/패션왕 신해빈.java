import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            hashMap.clear();
            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String s = st.nextToken();

                if(!hashMap.containsKey(s)){
                    hashMap.put(s,1);
                }else {
                    int count = hashMap.get(s);
                    hashMap.put(s,count+1);
                }
            }
            int sum=1;


            for(int k:hashMap.values()){
                sum*=(k+1);
            }
            sb.append(sum-1).append('\n');


        }
        System.out.println(sb);
    }
}
