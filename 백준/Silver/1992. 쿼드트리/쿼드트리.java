

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j)-'0';
            }
        }

        System.out.println(solution(0,0,N));
    }

    public static String solution(int x, int y, int size){
        if(size==1){
            return String.valueOf(map[y][x]);
        }

        int num = map[y][x];
        String s = "";

        for (int i = y; i < y+size ; i++) {
            for (int j = x; j < x+size ; j++) {
                if(num!=map[i][j]){
                    s += "(";
                    s += solution(x,y,size/2);
                    s += solution(x+size/2,y,size/2);
                    s += solution(x,y+size/2,size/2);
                    s += solution(x+size/2,y+size/2,size/2);
                    s += ")";
                    return s;
                }
            }
        }
        return String.valueOf(num);



    }
}
