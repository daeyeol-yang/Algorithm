

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static class SegTree {
        long[] tree;
        int size;  // 입력 배열 크기
        int leafStart;  // 리프 노드 시작 인덱스

        public SegTree(long[] arr) {
            this.size = arr.length;
            int h = (int) Math.ceil(Math.log(size) / Math.log(2));
            int treeSize = (int) Math.pow(2, h + 1);
            tree = new long[treeSize];
            leafStart = treeSize / 2;

            
            for (int i = 0; i < size; i++) {
                tree[leafStart + i] = arr[i];
            }

          
            for (int i = leafStart - 1; i > 0; i--) {
                tree[i] = tree[2 * i] + tree[2 * i + 1];
            }
        }

        public void update(int idx, long value) {
            int node = leafStart + idx;
            tree[node] = value;

            while (node > 1) {
                node /= 2;
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }

        public long query(int left, int right) {
            int l = leafStart + left;
            int r = leafStart + right;
            long sum = 0;

            while (l <= r) {
                if (l % 2 == 1) sum += tree[l++];
                if (r % 2 == 0) sum += tree[r--];
                l /= 2;
                r /= 2;
            }

            return sum;
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
                seg.update(a - 1, b);
            } else {
                int left = a - 1;
                int right = (int) b - 1;
                System.out.println(seg.query(left, right));
            }
        }
    }
}
