

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N,M,goal_x,goal_y;

    public static char[][] map;

    public static boolean check;

    public static int[][] fire_visited;
    public static int[][] J_visited;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        map = new char[N][M];

        int J_now_x =0;
        int J_now_y =0;
        int F_now_x =0;
        int F_now_y =0;

        ArrayList<int[]> fireList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j]= temp.charAt(j);
                if(map[i][j]=='F'){
                    fireList.add(new int[]{j,i});

                }

                else if(map[i][j]=='J'){
                    J_now_x=j;
                    J_now_y=i;
                }
            }
        }

        fire_visited = new int[N][M];
        J_visited = new int[N][M];

        bfs(fireList);
        bfsJ(J_now_x,J_now_y);

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(fire_visited[i]));
//        }

        if(check){
            System.out.println(J_visited[goal_y][goal_x]);
        }else{
            System.out.println("IMPOSSIBLE");

        }
    }


    public static void bfs(ArrayList<int[]> arrayList){
        Queue<int[]> queue = new LinkedList<>();

        for (int[] now : arrayList ){
            fire_visited[now[1]][now[0]]=1;

            queue.add(new int[]{now[0],now[1]});
        }


        while (!queue.isEmpty()){
            int[] now = queue.poll();

            int now_x = now[0];
            int now_y = now[1];

            for (int i = 0; i < 4; i++) {
                int next_x = now_x +dx[i];
                int next_y = now_y +dy[i];

                if(next_x>=0&&next_y>=0&&next_x<M&&next_y<N){
                    if(fire_visited[next_y][next_x]==0&&map[next_y][next_x]!='#'){

                        fire_visited[next_y][next_x] = fire_visited[now_y][now_x] +1;

                        queue.add(new int[]{next_x,next_y});

                    }


                }
            }
        }

    }

    public static void bfsJ(int x,int y){
        J_visited[y][x]=1;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] now = queue.poll();

            int now_x = now[0];
            int now_y = now[1];

            if(now_x == 0 || now_y == 0 ||now_y==N-1||now_x==M-1){
                goal_x=now_x;
                goal_y=now_y;
                check = true;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int next_x = now_x +dx[i];
                int next_y = now_y +dy[i];

                if(next_x>=0&&next_y>=0&&next_x<M&&next_y<N){

                    if(J_visited[next_y][next_x]==0&&map[next_y][next_x]!='#'){
                        if(fire_visited[next_y][next_x]==0||fire_visited[next_y][next_x]>J_visited[now_y][now_x]+1){

                            J_visited[next_y][next_x] = J_visited[now_y][now_x] +1;



                            queue.add(new int[]{next_x,next_y});

                        }

                    }


                }
            }
        }

    }
}
