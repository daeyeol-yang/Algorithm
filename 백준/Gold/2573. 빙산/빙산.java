

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N,M;

    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] countMap;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];



        // 입력값 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time =0;
        boolean notSeparate = false;
        int count;
        while (true){

            if(isCheckEnd()){
                notSeparate =true;
                break;
            }

            time++;

            melt();

            count =0;
            visited  = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!visited[i][j]&&map[i][j]>0){
                        dfs(j,i);
                        count++;
                    }
                }
            }

            if(count>=2){
                break;
            }
            
        }
        
        //출력
        if(notSeparate){
            System.out.println(0);
        }else{
            System.out.println(time);
        }


    }

    public static void dfs(int x, int y){
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x>=0&&next_y>=0&&next_x<M&&next_y<N&&!visited[next_y][next_x]&&map[next_y][next_x]>0){
                dfs(next_x,next_y);
            }
        }
    }

    public static boolean isCheckEnd(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]>0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void melt(){
        countMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]>0) {
                    for (int k = 0; k < 4; k++) {
                        int next_dx = j + dx[k];
                        int next_dy = i + dy[k];
                        if (next_dx >= 0 && next_dy >= 0 && next_dx < M && next_dy < N) {
                            if (map[next_dy][next_dx] == 0) {
                                countMap[i][j]++;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] -= countMap[i][j];

                if(map[i][j]<0){
                    map[i][j]=0;
                }
            }
        }
    }
}
