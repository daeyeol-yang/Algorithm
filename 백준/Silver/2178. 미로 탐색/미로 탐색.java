import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int []dx ={0,1,0,-1};
    static int []dy ={1,0,-1,0};
    static boolean [][]visited;
    static int [][]Array;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[N][M];
        visited=new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            String s= st.nextToken();
            for (int j = 0; j < M; j++) {
                Array[i][j]=Integer.parseInt(s.substring(j,j+1));
            }

        }

        BFS(0,0);
        System.out.println(Array[N-1][M-1]);

    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j]=true;
        while(!queue.isEmpty()){
            int []now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0]+dx[k];
                int y = now[1]+dy[k];
                if(x>=0&&y>=0&&x<N&&y<M){
                    if(Array[x][y]!=0&&!visited[x][y]){
                        visited[x][y]=true;
                        Array[x][y]=Array[now[0]][now[1]]+1;
                        queue.add(new int[]{x,y});
                    }

                }
            }
        }
    }
}
