

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx ={1,0,-1,0};
    public static int[] dy ={0,-1,0,1};

    public static boolean[][] visited;

    public static ArrayList<Integer>[][] arrayLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;



        arrayLists = new ArrayList[4][11];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 11; j++) {
                arrayLists[i][j] = new ArrayList<>();
            }
        }

        visited = new boolean[101][101];

        dragon();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            go(y,x,d,g);
        }


        int count =0;
        for (int i = 0; i < visited.length-1; i++) {
            for (int j = 0; j < visited.length-1; j++) {
                if(visited[i][j]&&visited[i+1][j]&&visited[i][j+1]&&visited[i+1][j+1]){
                    count++;
                }
            }
        }

//        for (int i = 0; i < 6; i++) {
//            System.out.println(Arrays.toString(visited[i]));
//        }

        System.out.println(count);


    }

    public static void dragon(){
        for (int i = 0; i < 4; i++) {
            arrayLists[i][0].add(i);
            for (int j = 1; j < 11; j++) {

                for (int k = 0; k < arrayLists[i][j-1].size(); k++) {
                    arrayLists[i][j].add(arrayLists[i][j-1].get(k));
                }

                for (int k = arrayLists[i][j-1].size()-1; k >=0 ; k--) {
                    arrayLists[i][j].add(arrayLists[i][j-1].get(k)+1);
                }

            }
        }

    }

    public static void go(int y, int x, int d, int g){
        visited[y][x] =true;
        int now_x = x;
        int now_y = y;
        for (int i = 0; i < arrayLists[d][g].size(); i++) {
            int index = arrayLists[d][g].get(i)%4;
            // System.out.println(index);
            int next_x = now_x+dx[index];
            int next_y = now_y+dy[index];
            visited[next_y][next_x] = true;
            now_y = next_y;
            now_x = next_x;
        }
    }
}
