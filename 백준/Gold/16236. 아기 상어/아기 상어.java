

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static class Fish{
        int index;
        int x;
        int y;
        int size;
        int dist;

        public Fish(int index,int x, int y, int size) {
            this.index=index;
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "index=" + index +
                    ", x=" + x +
                    ", y=" + y +
                    ", size=" + size +
                    ", dist=" + dist +
                    '}';
        }
    }
    static Fish babyShark;
    static int SIZE;

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SIZE = Integer.parseInt(br.readLine());
        map = new int[SIZE][SIZE];
        StringTokenizer st;
        int index =0;
        List<Fish> fishList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    babyShark = new Fish(0,j,i,2);
                    map[i][j] = 0;
                } else if (map[i][j]!=0) {
                    fishList.add(new Fish(++index,j,i,map[i][j]));
                }
            }
        }

        //target 정하는 큐 선언
        PriorityQueue<Fish> targetList = new PriorityQueue<>((o1, o2) -> {
            if(o1.dist==o2.dist){
                if(o1.y==o2.y){
                    return Integer.compare(o1.x,o2.x);
                }else{
                    return Integer.compare(o1.y,o2.y);
                }
            }else{
                return Integer.compare(o1.dist,o2.dist);
            }
        });
        int time =0;
        int eatCount =0;
        while(true) {

            targetList.clear();
            //target 찾기
            for (Fish target : fishList) {
                if (target.size < babyShark.size) {
                    visited = new int[SIZE][SIZE];
                    int dist = bfs(babyShark.x, babyShark.y, target.x, target.y);
                    if (dist == -1) {
                        continue;
                    }
                    target.dist = dist;
                    targetList.add(target);
                }
            }

            if(!targetList.isEmpty()){
                Fish target = targetList.poll();
                
                babyShark.x = target.x;
                babyShark.y = target.y;

                time += target.dist;

                if( babyShark.size==++eatCount){
                    babyShark.size+=1;
                    eatCount=0;
                }
                for(Fish temp : fishList){
                    if(temp.index==target.index){
                        fishList.remove(temp);
                        break;
                    }
                }

            }else{
                break;
            }

        }
        System.out.println(time);

    }

    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static boolean isRange(int x, int y){
        return x>=0 && y>=0 && x< SIZE && y<SIZE;
    }
    public static int bfs(int startX , int startY, int targetX , int targetY){
        visited[startY][startX] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});

        while(!queue.isEmpty()){
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            if(nowX==targetX && nowY == targetY){
                return visited[nowY][nowX]-1;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(!isRange(nextX,nextY)){
                    continue;
                }
                if(visited[nextY][nextX]==0 && map[nextY][nextX]<=babyShark.size){
                    visited[nextY][nextX] = visited[nowY][nowX] + 1;
                    queue.add(new int[]{nextX,nextY});
                }
            }


        }

        return -1;
    }


}
