import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long s, c, ret, sum;
    static long[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        a = new long[(int) s]; // 배열 크기 설정
        sum = 0; // 전체 합

        for (int i = 0; i < s; i++) {
            a[i] = Long.parseLong(br.readLine());
            sum += a[i]; // 총 길이 계산
        }

        long lo = 1, hi = (long) 1e9;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (check(mid)) {
                lo = mid + 1;
                ret = mid;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(sum - ret * c);
    }

    public static boolean check(long mid) {
        long cnt = 0;
        for (int i = 0; i < s; i++) {
            cnt += a[i] / mid;
        }
        return cnt >= c;
    }
}
