

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, -1, 0, 1};

    public static int size;

    public static int[][] map;
    public static int[][] visited;

    public static int N, M;

    public static ArrayList<Integer> sizeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력

        visited = new int[N][M];
        sizeList = new ArrayList<>();
        int count = 1;
        int maxSize =0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    size = 0;
                    dfs(j, i, count);
                    sizeList.add(size);
                    maxSize = Math.max(size,maxSize);
                    count++;
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(visited[i]));
//        }


        StringBuilder sb = new StringBuilder();
        sb.append(count-1).append('\n');
        sb.append(maxSize).append('\n');

        sb.append(drop()).append('\n');


        System.out.println(sb);


    }

    public static int drop(){
        int maxSize =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    int next_x = j+dx[k];
                    int next_y = i+dy[k];

                    if(next_y>=0&&next_x>=0&&next_x<M&&next_y<N){
                        if(visited[next_y][next_x]!=visited[i][j]){
                            int sum = sizeList.get(visited[next_y][next_x]-1) + sizeList.get(visited[i][j]-1);
                            maxSize = Math.max(maxSize, sum);
                        }
                    }
                }
            }
        }
        return maxSize;

    }

    public static void dfs(int x, int y, int count) {

        visited[y][x] = count;
        size++;
        for (int i = 0; i < 4; i++) {
            if ((map[y][x] & (1 << i)) == 0) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                if(next_y>=0&&next_x>=0&&next_x<M&&next_y<N&&visited[next_y][next_x]==0){

                    dfs(next_x,next_y,count);
                }
            }
        }
    }
}
