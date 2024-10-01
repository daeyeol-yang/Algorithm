

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            count =0;
            bfs(A,B);
            sb.append(count).append('\n');

        }

        System.out.println(sb);
    }

    public static void bfs(int A, int B){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{A,B});
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] now = queue.poll();
                int scoreS = now[0];
                int scoreT = now[1];



                if (scoreT == scoreS) {
                    return;
                }

                if (scoreS < scoreT) {
                    queue.add(new int[] {2 * scoreS, scoreT + 3});
                    queue.add(new int[] {scoreS + 1, scoreT});
                }
            }
            count++;
        }

    }
}


