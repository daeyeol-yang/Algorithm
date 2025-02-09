import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lis = new int[1000004];
        Arrays.fill(lis, Integer.MAX_VALUE);
        int len = 0;
        Pair[] ans = new Pair[n];
        Stack<Integer> stk = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int pos = Arrays.binarySearch(lis, 0, len, num);
            if (pos < 0) pos = -(pos + 1);
            if (lis[pos] == Integer.MAX_VALUE) len++;
            lis[pos] = num;
            ans[i] = new Pair(pos, num);
        }
        
        System.out.println(len);
        for (int i = n - 1; i >= 0; i--) {
            if (ans[i].first == len - 1) {
                stk.push(ans[i].second);
                len--;
            }
        }
        
        while (!stk.isEmpty()) {
            System.out.println(stk.pop());
        }
    }
    
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
