

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int max;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static char[][] map;

    public static HashSet<Character> hashSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N  = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        hashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }




        dfs(0,0);


        System.out.println(max);

    }

    public static void dfs(int x, int y){
        hashSet.add(map[y][x]);

        max = Math.max(max,hashSet.size());

        for (int i = 0; i < 4; i++) {

            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x>=0&& next_y>=0 && next_x<M && next_y<N && !hashSet.contains(map[next_y][next_x])){
                dfs(next_x,next_y);
                hashSet.remove(map[next_y][next_x]);
            }

        }

    }
}
