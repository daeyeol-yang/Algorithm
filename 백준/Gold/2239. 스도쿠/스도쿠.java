
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();
    static boolean finished = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = temp.charAt(j) - '0';
                if (map[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }
        //System.out.println(blanks.size());

        go(0);
    }

    public static void go(int index) {
        if (finished) return;

        if (index == blanks.size()) {
            // 정답 출력
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            finished = true;
            return;
        }

        int[] zero = blanks.get(index);
        int y = zero[0];
        int x = zero[1];

        for (int num = 1; num <= 9; num++) {
            map[y][x] = num;
            if (garoCheck(x, y) && seroCheck(x, y) && boxCheck(x, y)) {
                go(index + 1);
            }
            map[y][x] = 0;
        }
    }


    public static boolean garoCheck(int x , int y) {

        for(int i = 0 ; i<9;i++) {
            if(map[y][x]==map[y][i]) {
                if(x==i) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }


    public static boolean seroCheck(int x, int y) {
        for(int i=0;i<9;i++) {
            if(map[y][x]==map[i][x]) {
                if(y==i) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static boolean boxCheck(int x, int y) {
        int Xx = (x/3)*3;
        int Yy = (y/3)*3;
        for(int i = Yy ; i<Yy+3 ; i++) {
            for(int j = Xx ; j<Xx+3 ; j++) {
                if(y==i && x == j) {
                    continue;
                }
                if(map[y][x]==map[i][j]) {
                    return false;
                }
            }
        }
        return true;

    }

}
