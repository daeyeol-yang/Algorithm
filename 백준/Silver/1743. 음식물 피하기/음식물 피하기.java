
import java.io.*;
import java.util.*;

public class Main {

    public static boolean[][] map;
    public static boolean[][] visited;

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};

    public static int N;
    public static int M;

    public static int count;

    public static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map  = new boolean[N][M];
        visited  = new boolean[N][M];
        list = new ArrayList<>();

        int num = Integer.parseInt(st.nextToken());

        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            map[first-1][second-1] = true;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]&&map[i][j]){
                    count=0;
                    dfs(j,i);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.get(list.size()-1));

        
    }

    public static void dfs(int x, int y){
        visited[y][x]=true;
        count++;

        for(int i=0; i < 4; i++){
            int next_x = x+dx[i];
            int next_y = y+dy[i];

            if(next_x>=0&&next_y>=0 && next_x<M &&next_y<N){
                if(!visited[next_y][next_x]&&map[next_y][next_x]){
                    dfs(next_x,next_y);
                }
            }

        }
    }
}
