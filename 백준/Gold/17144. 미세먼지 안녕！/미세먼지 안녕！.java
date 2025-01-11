

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int[][] tempMap;
    public static int[][] map;

    public static int N,M;

    public static ArrayList<int[]> air1;
    public static ArrayList<int[]> air2;

    public static int[] dx ={1,0,-1,0};
    public static int[] dy ={0,-1,0,1};
    public static int[] dx1 ={1,0,-1,0};
    public static int[] dy1 ={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Time = Integer.parseInt(st.nextToken());

        air1 = new ArrayList<int[]>();
        air2 = new ArrayList<int[]>();

        map = new int[N][M];

        boolean check = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j]==-1){
                    if(!check) {
                        air1 = collectGogi(j,i,dy,dx);
                        check=true;
                    }else {
                        air2 = collectGogi(j,i,dy1,dx1);
                    }
                }
            }
        }


        for (int time = 0; time < Time; time++) {
            misePlay();
            play(air1);
            play(air2);
        }

        int sol =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]>=0){
                    sol += map[i][j];
                }
            }
        }

        System.out.println(sol);


    }

    public static void play(ArrayList<int[]> air){


        for (int i = air.size()-1; i > 0  ; i--) {
            int[] temp =air.get(i);
            int[] temp1 = air.get(i-1);

            map[temp[1]][temp[0]] = map[temp1[1]][temp1[0]];

        }
        map[air.get(0)[1]][air.get(0)[0]] = 0;
    }

    public static ArrayList<int[]> collectGogi(int firstX, int firstY, int[] dy, int[] dx){
        ArrayList<int[]> temp = new ArrayList<>();
        int now_x = firstX;
        int now_y = firstY;
        int index =0;
        while (true){

            int next_x =  now_x+dx[index];
            int next_y =  now_y+dy[index];
            if(next_x==firstX&&next_y==firstY){
                break;
            }
            if(!(next_y<N&&next_y>=0&&next_x<M&&next_x>=0)){
                index++;
                next_x = now_x+dx[index];
                next_y = now_y+dy[index];
            }
            if(next_x==firstX&&next_y==firstY){
                break;
            }
            now_x = next_x;
            now_y = next_y;
            temp.add(new int[]{now_x,now_y});


        }
        return temp;

    }


    public static void misePlay(){
        tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]>0){
                    int spread = map[i][j]/5;

                    for (int k = 0; k < 4; k++) {
                        int next_x = j+dx[k];
                        int next_y = i+dy[k];

                        if(next_y<N&&next_y>=0&&next_x<M&&next_x>=0&&map[next_y][next_x]!=-1){
                            tempMap[next_y][next_x] += spread;
                            map[i][j] -= spread;
                        }
                    }

                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] += tempMap[i][j];
            }
        }
        

    }
}
