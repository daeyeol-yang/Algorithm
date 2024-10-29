

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] map;

    public static int a,b,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0,0,N);
        System.out.println(c);
        System.out.println(b);
        System.out.println(a);
    }

    public static void solution(int x, int y, int size){
//        if(size==1){
//            if(map[y][x]==1){
//                a+=1;
//            } else if (map[y][x]==0) {
//                b+=1;
//            } else {
//                c+=1;
//            }
//            return;
//        }

        int num = map[y][x];

        for (int i = y; i < y+size ; i++) {
            for (int j = x; j <x+size ; j++) {
                if(map[i][j]!=num){
                    solution(x,y,size/3);
                    solution(x+size/3,y,size/3);
                    solution(x+size*2/3,y,size/3);
                    solution(x,y+size/3,size/3);
                    solution(x+size/3,y+size/3,size/3);
                    solution(x+size*2/3,y+size/3,size/3);
                    solution(x,y+size*2/3,size/3);
                    solution(x+size/3,y+size*2/3,size/3);
                    solution(x+size*2/3,y+size*2/3,size/3);
                    return;
                }
            }
        }

        if(map[y][x]==1){
            a+=1;
        } else if (map[y][x]==0) {
            b+=1;
        } else {
            c+=1;
        }


    }
}
