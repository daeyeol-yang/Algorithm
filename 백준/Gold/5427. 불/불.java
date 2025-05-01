

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] dx= {0,0,1,-1};
    static  int[] dy = {1,-1,0,0};
    static class Point{
        int x;
        int y;
        int time;
        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static char[][] map;
    static boolean[][] visited;
    static int[][] visited1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TESTCASE = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase <TESTCASE ; testCase++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            visited = new boolean[N][M];
            visited1 = new int[N][M];


            Queue<Point> fireQueue = new ArrayDeque<>();
            Queue<Point> queue = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = temp.charAt(j);
                    if(map[i][j]=='@'){
                        map[i][j] = '.';
                        visited[i][j]=true;
                        queue.add(new Point(j,i,0));
                    } else if (map[i][j]=='*') {
                        fireQueue.add(new Point(j,i,0));
                    }
                }
            }


            int check = -1;
            while(!queue.isEmpty()){
                Point nowPoint = queue.poll();
                int nowX = nowPoint.x;
                int nowY = nowPoint.y;
                int time= nowPoint.time;
                if(isEnd(nowX,nowY)){
                    check =time;
                    break;
                }

                while(!fireQueue.isEmpty()&&time == fireQueue.peek().time){
                    Point nowFirePoint = fireQueue.poll();
                    int nowFireX = nowFirePoint.x;
                    int nowFireY = nowFirePoint.y;
                    int nowTime = nowFirePoint.time;

                    for (int i = 0; i < 4; i++) {
                        int nextFireX = nowFireX+dx[i];
                        int nextFireY = nowFireY+dy[i];

                        if(!isRange(nextFireX,nextFireY)){
                                continue;
                            }
                        if(map[nextFireY][nextFireX]=='.'){
                                map[nextFireY][nextFireX]='*';
                                fireQueue.add(new Point(nextFireX,nextFireY,nowTime+1));
                            }

                    }

                }

                for (int i = 0; i < 4; i++) {
                    int nextX = nowX+dx[i];
                    int nextY = nowY+dy[i];

                    if(!isRange(nextX,nextY)){
                        continue;
                    }
                    if(map[nextY][nextX]=='.'&&!visited[nextY][nextX]){
                        visited[nextY][nextX] = true;
                        queue.add(new Point(nextX,nextY,time+1));
                    }
                }



            }

//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(visited1[i]));
//            } for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }

            if(check!=-1){
                sb.append(check+1);
            }else{
                sb.append("IMPOSSIBLE");
            }
            sb.append('\n');



        }
        System.out.println(sb);
    }
    static boolean isRange(int x, int y){
        return x>=0 && y>=0 && x<M && y<N;
    }

    static boolean isEnd(int x, int y){
        return x==0 || y==0 || x==M-1 || y==N-1;
    }
}
