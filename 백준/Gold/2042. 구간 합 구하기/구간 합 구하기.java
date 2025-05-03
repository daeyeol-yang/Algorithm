import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class SegTree {
        long[] tree;
        int N;

        public SegTree(long[] arr) {
            N = arr.length;
            tree = new long[4 * N];
            build(arr, 1, 0, N - 1);
        }

        private void build(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(arr, node * 2, start, mid);
                build(arr, node * 2 + 1, mid + 1, end);
                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }
        }

        public void update(int idx, long val) {
            update(1, 0, N - 1, idx, val);
        }

        private void update(int node, int start, int end, int idx, long val) {
            if (start == end) {
                tree[node] = val;
            } else {
                int mid = (start + end) / 2;
                if (idx <= mid) {
                    update(node * 2, start, mid, idx, val);
                } else {
                    update(node * 2 + 1, mid + 1, end, idx, val);
                }
                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }
        }

        public long query(int l, int r) {
            return query(1, 0, N - 1, l, r);
        }

        private long query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return tree[node];

            int mid = (start + end) / 2;
            return query(node * 2, start, mid, l, r)
                 + query(node * 2 + 1, mid + 1, end, l, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegTree seg = new SegTree(arr);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (type == 1) {
                seg.update(a - 1, b); // 1-based → 0-based
            } else {
                int left = a - 1;
                int right = (int) b - 1;
                System.out.println(seg.query(left, right));
            }
        }
    }
}
