

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        HashMap<Integer,Long> aMap = new HashMap<>();
        HashMap<Integer,Long> bMap = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] dA = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            dA[i+1] = a[i] + dA[i];
        }

        for (int i = 0; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                int result = dA[j]-dA[i];
                aMap.put(result,aMap.getOrDefault(result,0L)+1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        int[] b = new int[M];
        int[] dB = new int[M+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            dB[i+1] = b[i] + dB[i];
        }


        for (int i = 0; i <= M; i++) {
            for (int j = i+1; j <= M; j++) {
                int result = dB[j]-dB[i];
                bMap.put(result,bMap.getOrDefault(result,0L)+1);
            }
        }

        long count =0;
        for (int num : aMap.keySet()) {
            
            if(bMap.containsKey(target-num)){
                
                count+= aMap.get(num) * bMap.get(target-num);
               
            }
        }

        System.out.println(count);


    }


}
