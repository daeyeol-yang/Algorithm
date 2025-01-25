

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;

    public static int[][] map;

    public static ArrayList<int[]> cctv;


    public static int cctvSize;

    public static int sol = Integer.MAX_VALUE;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctv.add(new int[] {j, i});
                }
            }
        }

        cctvSize = cctv.size();
        dfs(0);


        System.out.println(sol);

    }


    public static void dfs(int count) {

        if (count == cctvSize) {
            int sagak = countSagak();
            //print();
            sol = Math.min(sagak, sol);
            return;
        }


            int now_x = cctv.get(count)[0];
            int now_y = cctv.get(count)[1];

            for (int j = 0; j < 4; j++) {

                ArrayList<int[]> back = cctvGo(now_x, now_y, j);
                dfs(count + 1);
                cctvBack(back);
            }




    }

    public static void print(){
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    public static ArrayList<int[]> cctvGo(int x, int y, int d) {
        int num = map[y][x];
        ArrayList<int[]> back=new ArrayList<>();

        switch (num) {
            case 1:
                cctv1(x, y, d,back);
                break;
            case 2:
                cctv1(x, y, d,back);
                cctv1(x, y, (d + 2) % 4,back);
                break;
            case 3:
                cctv1(x,y,d,back);
                cctv1(x,y,(d+1)%4,back);
                break;

            case 4:
                cctv1(x,y,d,back);
                cctv1(x,y,(d+1)%4,back);
                cctv1(x,y,(d+2)%4,back);
                break;

            case 5:
                cctv1(x,y,d,back);
                cctv1(x,y,(d+1)%4,back);
                cctv1(x,y,(d+2)%4,back);
                cctv1(x,y,(d+3)%4,back);
                break;
        }

        return back;

    }

    public static boolean arrayCheck(int x, int y) {
        if (y < 0 || x < 0 || y >= N || x >= M) {
            return false;
        } else {
            return true;
        }
    }

    public static void cctv1(int x, int y, int d,ArrayList<int[]> back) {
        int next_x = x + dx[d];
        int next_y = y + dy[d];

        if (arrayCheck(next_x, next_y) && map[next_y][next_x]!=6) {
            if(map[next_y][next_x]==0){
                map[next_y][next_x] = 7;
                back.add(new int[]{next_x,next_y});
            }

            cctv1(next_x, next_y, d,back);
        }
    }

    public static void cctvBack(ArrayList<int[]> back) {

        for(int[] temp : back){
            map[temp[1]][temp[0]] = 0;
        }

    }


    public static int countSagak() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;

    }
}
