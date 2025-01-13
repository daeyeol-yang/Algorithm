

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y-1][x-1] = 1;
        }
        
        int L = Integer.parseInt(br.readLine());

        ArrayList<String[]> arrayList = new ArrayList<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            String timeChange = st.nextToken();
            String d = st.nextToken();

            arrayList.add(new String[]{timeChange,d});
        }

        Deque<int[]> deque = new ArrayDeque<>();

        deque.add(new int[]{0,0});
        visited[0][0] = true;



        int time =0;
        int index =0;

        int timeIndex =0;

        while (true){

            time++;

            int[] now = deque.peekLast();
            int now_x = now[0];
            int now_y = now[1];

            int next_x = now_x+dx[index];
            int next_y = now_y+dy[index];

            if(next_x<0||next_y<0||next_x>=N||next_y>=N){
                break;
            }

            if(visited[next_y][next_x]){
                break;
            }

            if(map[next_y][next_x]==1){
                map[next_y][next_x]=0;
                visited[next_y][next_x] = true;
                deque.addLast(new int[]{next_x,next_y});
            }else{
                visited[next_y][next_x] = true;
                int[] temp =  deque.peekFirst();
                visited[temp[1]][temp[0]] = false;
                deque.addLast(new int[]{next_x,next_y});
                deque.pollFirst();
            }

            if(time==Integer.parseInt(arrayList.get(timeIndex)[0])){
                char c = arrayList.get(timeIndex)[1].charAt(0);

                if(timeIndex< arrayList.size()-1){
                    timeIndex++;
                }

                if(c=='L'){
                    index= (index+1)%4;
                }else{
                    index--;
                    if(index<0){
                        index+=4;
                    }
                }



            }

        }

        System.out.println(time);
    }
}
