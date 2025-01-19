

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] malIndex;

    public static int[] navi;

    public static ArrayList<Integer>[] map;

    public static int[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        malIndex = new int[4];

        map = new ArrayList[33];

        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }

        navi = new int[11];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            navi[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 20; i++) {
            map[i].add(i + 1);
        }

        map[5].add(21);
        map[21].add(22);
        map[22].add(23);
        map[23].add(24);

        map[10].add(25);
        map[25].add(26);
        map[26].add(24);

        map[15].add(27);
        map[27].add(28);
        map[28].add(29);
        map[29].add(24);

        map[24].add(30);
        map[30].add(31);
        map[31].add(20);

        map[20].add(100);//도착


        v = new int[104];

        for (int i = 0; i <= 20; i++) {
            v[i] = 2 * i;
        }

        v[21] = 13;
        v[22] = 16;
        v[23] = 19;
        v[24] = 25;

        v[25] = 22;
        v[26] = 24;

        v[27] = 28;
        v[28] = 27;
        v[29] = 26;

        v[30] = 30;
        v[31] = 35;
        
        System.out.println(play(0));


    }

    public static boolean isMal(int mal, int index) {
        if (index == 100) return false;
        for (int i = 0; i < 4; i++) {
            if (mal == i) continue;
            if (malIndex[i] == index) {
                return true;
            }
        }
        return false;
    }

    public static int move(int nowMalIndex, int steps) {
        if (nowMalIndex == 100) return 100;

        if (map[nowMalIndex].size() > 1) {
            nowMalIndex = map[nowMalIndex].get(1);
            steps--;
        }

        while (steps > 0) {
            nowMalIndex = map[nowMalIndex].get(0);
            steps--;
            if (nowMalIndex == 100) break;
        }
        return nowMalIndex;
    }

    public static int play(int index) {
        if (index == 10) return 0;

        int sol = 0;

        for (int i = 0; i < 4; i++) {
            int nowMalIndex = malIndex[i];
            int nextMalIndex = move(nowMalIndex, navi[index]);

            if (isMal(i, nextMalIndex)) continue;

            malIndex[i] = nextMalIndex;
            sol = Math.max(sol, play(index + 1) + v[nextMalIndex]);
            malIndex[i] = nowMalIndex;
        }

        return sol;
    }
    
    
}



