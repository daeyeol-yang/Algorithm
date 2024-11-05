import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[][] map;
    public static ArrayList<Integer> sol;
    public static ArrayList<int[]> house;
    public static ArrayList<int[]> chick;
    public static ArrayList<int[]> selectedChicks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        sol = new ArrayList<>();
        house = new ArrayList<>();
        chick = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new int[]{j, i});
                } else if (map[i][j] == 2) {
                    chick.add(new int[]{j, i});
                }
            }
        }

        selectedChicks = new ArrayList<>();
        selectChickHouse(0, 0);
        System.out.println(Collections.min(sol)); // 최소 거리 출력
    }

    public static void selectChickHouse(int start, int depth) {
        if (depth == M) {
            sol.add(calculateDistance());
            return;
        }

        for (int i = start; i < chick.size(); i++) {
            selectedChicks.add(chick.get(i));
            selectChickHouse(i + 1, depth + 1); // 중복 방지를 위해 i+1 사용
            selectedChicks.remove(selectedChicks.size() - 1);
        }
    }

    public static int calculateDistance() {
        int totalDistance = 0;

        for (int[] home : house) {
            int minDistance = Integer.MAX_VALUE;
            for (int[] c : selectedChicks) {
                int distance = Math.abs(c[0] - home[0]) + Math.abs(c[1] - home[1]);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }
        
        return totalDistance;
    }
}
