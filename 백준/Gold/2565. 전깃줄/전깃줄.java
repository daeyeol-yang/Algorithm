import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> v = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v.add(new int[]{a, b});
        }
        
        v.sort(Comparator.comparingInt(o -> o[0]));
        
        List<Integer> lis = new ArrayList<>();
        for (int[] pair : v) {
            int pos = Collections.binarySearch(lis, pair[1]);
            if (pos < 0) pos = -(pos + 1);
            if (pos == lis.size()) {
                lis.add(pair[1]);
            } else {
                lis.set(pos, pair[1]);
            }
        }
        
        System.out.println(n - lis.size());
    }
}
