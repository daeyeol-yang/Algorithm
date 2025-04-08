
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class B1194 {
//
//    public static void main(String[] args) throws IOException {
//        // TODO Auto-generated method stub
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        map = new int[9][9];
//        count= 0;
//        for(int i = 0; i<9 ; i++) {
//            String temp = br.readLine();
//            for(int j =0; j< 9 ;j++) {
//                map[i][j] = temp.charAt(j)-'0';
//                if(map[i][j]==0) {
//                    count++;
//                }
//            }
//        }
//
//        for(int i = 0; i<9 ; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println(count);
//
//        go(0);
//
//    }
//    static int[][] map;
//    static int count;
//
//    public static void go(int index) {
//        System.out.println(index);
//        if(count==index) {
//            for(int i = 0; i<9 ; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            return;
//        }
//
//        for(int i = 0; i< 9 ; i++) {
//            for(int j = 0; j< 9 ; j++) {
//                if(map[i][j]==0) {
//
//                    for(int num = 1;num<=9;num++) {
//
//                        map[i][j] = num;
//                        if(garoCheck(j, i) && seroCheck(j, i) && boxCheck(j, i)) {
//
//                            go(index+1);
//                        }
//                        map[i][j] = 0;
//                    }
//
//                }
//
//
//            }
//        }
//
//    }
//
//    public static boolean garoCheck(int x , int y) {
//
//        for(int i = 0 ; i<9;i++) {
//            if(map[y][x]==map[y][i]) {
//                if(x==i) {
//                    continue;
//                }
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//    public static boolean seroCheck(int x, int y) {
//        for(int i=0;i<9;i++) {
//            if(map[y][x]==map[i][x]) {
//                if(y==i) {
//                    continue;
//                }
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean boxCheck(int x, int y) {
//        int Xx = (x/3)*3;
//        int Yy = (y/3)*3;
//        for(int i = Yy ; i<Yy+3 ; i++) {
//            for(int j = Xx ; j<Xx+3 ; j++) {
//                if(y==i && x == j) {
//                    continue;
//                }
//                if(map[y][x]==map[i][j]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//
//    }
//}
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

        int[] pos = blanks.get(index);
        int y = pos[0];
        int x = pos[1];

        for (int num = 1; num <= 9; num++) {
            map[y][x] = num;
            if (isValid(x, y)) {
                go(index + 1);
            }
            map[y][x] = 0;
        }
    }

    public static boolean isValid(int x, int y) {
        return rowCheck(x, y) && colCheck(x, y) && boxCheck(x, y);
    }

    public static boolean rowCheck(int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (i != x && map[y][i] == map[y][x]) return false;
        }
        return true;
    }

    public static boolean colCheck(int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (i != y && map[i][x] == map[y][x]) return false;
        }
        return true;
    }

    public static boolean boxCheck(int x, int y) {
        int startRow = (y / 3) * 3;
        int startCol = (x / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (i == y && j == x) continue;
                if (map[i][j] == map[y][x]) return false;
            }
        }
        return true;
    }
}
