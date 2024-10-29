

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static int N,M,count;

    public static boolean[][] visited, map;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        map = new boolean[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st= new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 =M-Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 =M - Integer.parseInt(st.nextToken());


            for (int j = y2; j <y1 ; j++) {
                for (int k = x1; k <x2 ; k++) {
                    map[j][k]=true;
                }
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        int size =0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!map[i][j]&&!visited[i][j]){
                    count=0;
                    dfs(j,i);
                    size++;
                    arrayList.add(count);
                }
            }
        }

        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        sb.append(size).append('\n');

        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y){
        visited[y][x] =true;
        count+=1;

        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x>=0&&next_x<N&&next_y>=0&&next_y<M){
                if(!visited[next_y][next_x]&&!map[next_y][next_x]){
                    dfs(next_x,next_y);
                }
            }
        }


    }
}
