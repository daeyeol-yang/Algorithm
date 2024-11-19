

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int sum;

    public static int min;

    public static int N;

    public static boolean visited[][];
    public static int map[][];

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;


        flower(0,0);

        System.out.println(min);


    }

    public static void flower(int count, int sum){
        if(count==3){
            min = Math.min(sum,min);
            return;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(check(j,i)){
                    int sumTemp = sumFlower(j,i);
                    flower(count+1, sum + sumTemp);
                    eraseFlower(j,i);
                }
            }
        }


    }

    public static boolean check(int x, int y){
        if(visited[y][x]){
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x>=0&&next_y>=0&&next_x<N&&next_y<N){
                if(visited[next_y][next_x]){
                    return false;
                }
            }else{
                return false;
            }


        }
        return true;
    }

    public static int sumFlower(int x, int y){
        int sum =0;
        visited[y][x] = true;
        sum += map[y][x];

        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x>=0&&next_y>=0&&next_x<N&&next_y<N) {

                visited[next_y][next_x] = true;
                sum += map[next_y][next_x];
            }
        }
        return sum;

    }

    public static void eraseFlower(int x, int y){
        visited[y][x] = false;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x>=0&&next_y>=0&&next_x<N&&next_y<N) {

                visited[next_y][next_x] = false;
            }
        }

    }
}
