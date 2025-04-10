import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Atomic {
        int x, y, dir, power;

        public Atomic(int x, int y, int dir, int power) {
            this.x = x * 2;  // 실수 좌표 방지
            this.y = y * 2;
            this.dir = dir;
            this.power = power;
        }
    }

    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TESTCASE = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= TESTCASE; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine());
            List<Atomic> atomicList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());

                atomicList.add(new Atomic(x, y, dir, power));
            }

            int sol = 0;
            int time = 4000;

            Map<Integer, List<Integer>> atomicMap = new HashMap<>();

            while (time!= 0 && !atomicList.isEmpty()) {
                atomicMap.clear();

               
                for (int i = 0; i < atomicList.size(); i++) {
                    Atomic atom = atomicList.get(i);
                    atom.x += dx[atom.dir];
                    atom.y += dy[atom.dir];

                    // 경계
                    if (atom.x < -2000 || atom.x > 2000 || atom.y < -2000 || atom.y > 2000) {
                        atom.power = -1; // 삭제 
                        continue;
                    }

                    int key = (atom.x + 2000) * 4001 + (atom.y + 2000);
                    atomicMap.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
                }

                // 충돌
                Set<Integer> dead = new HashSet<>();
                for (List<Integer> ids : atomicMap.values()) {
                    if (ids.size() > 1) {
                        for (int id : ids) {
                            if (atomicList.get(id).power != -1) {
                                sol += atomicList.get(id).power;
                                dead.add(id);
                            }
                        }
                    }
                }

                // 살아남은 원자만 필터링
                List<Atomic> newList = new ArrayList<>();
                for (int i = 0; i < atomicList.size(); i++) {
                    if (atomicList.get(i).power != -1 && !dead.contains(i)) {
                        newList.add(atomicList.get(i));
                    }
                }

                atomicList = newList;
                time--;
            }

            sb.append(sol).append('\n');
        }

        System.out.println(sb);
    }
}
