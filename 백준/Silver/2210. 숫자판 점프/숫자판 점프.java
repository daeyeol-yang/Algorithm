

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr= new int[5][5];

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static HashSet<String> hashSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());
            }

        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(j,i,6,"");
            }
        }


        System.out.println(hashSet.size());


    }

    public static void dfs(int x, int y, int num, String s){

        if(num==0){
            hashSet.add(s);

            return;
        }


        for (int i = 0; i < 4; i++) {

            int next_x = x+dx[i];
            int next_y = y+dy[i];

            if(next_x>=0&&next_y>=0&&next_x<5&&next_y<5){
                String newS=s.concat(String.valueOf(arr[next_y][next_x]));

                dfs(next_x,next_y,num-1,newS);
            }
        }
    }
}
