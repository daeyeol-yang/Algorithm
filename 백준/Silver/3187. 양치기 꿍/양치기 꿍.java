
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;

    public static char[][] map;
    public static boolean[][] visited;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static int sheep;
    public static int wolf;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        int totalsheep =0;
        int totalWolf =0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sheep=0;
                wolf=0;
                if(map[i][j]!='#'&&!visited[i][j]){
                    bfs(j,i);
                   
                    if(sheep>wolf){
                        totalsheep+=sheep;
                    }else{
                        totalWolf+=wolf;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(totalsheep).append(" ").append(totalWolf);



        System.out.println(sb);


    }

    public static void bfs(int x, int y){
        visited[y][x] = true;

        Queue<int[]> queue =new LinkedList<>();

        queue.offer(new int[]{x,y});
        if(map[y][x]=='v'){
            wolf++;
        }
        if(map[y][x]=='k'){
            sheep++;
        }

        while (!queue.isEmpty()){
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = now[0] + dx[i];
                int next_y = now[1] + dy[i];
                if(next_x>=0&&next_y>=0&&next_x<M&&next_y<N&&!visited[next_y][next_x]&&map[next_y][next_x]!='#'){
                    visited[next_y][next_x] = true;
                    if(map[next_y][next_x]=='v'){
                        wolf++;

                    }
                    if(map[next_y][next_x]=='k'){
                        sheep++;
                    }
                    queue.add(new int[]{next_x,next_y});
                }
            }

        }
    }
}
