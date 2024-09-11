

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M, K;

    public static char[][] map;
    public static boolean[][] visited;

    public static int[] dx = { 0,0,1,-1};
    public static int[] dy = { 1,-1,0,0};

    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        dfs(0,N-1,1);


        System.out.println(count);

    }


    public static void dfs(int x, int y, int depth){
        visited[y][x]=true;

        if(depth==K&&y==0&&x==M-1){
            count++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int next_x = x+dx[i];
            int next_y = y+dy[i];

            if(next_x>=0&&next_y>=0&&next_x<M&&next_y<N&&!visited[next_y][next_x]&&map[next_y][next_x]!='T'){
                dfs(next_x,next_y,depth+1);
                visited[next_y][next_x]=false;
            }
        }


    }
}
