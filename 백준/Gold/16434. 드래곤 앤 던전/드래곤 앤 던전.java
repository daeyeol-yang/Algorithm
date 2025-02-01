

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, attack;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 방의 개수
        N = Integer.parseInt(st.nextToken());
        // 용사의 초기 공격력
        attack = Integer.parseInt(st.nextToken());

        map = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken()); // 방 타입 (1: 전투, 2: 포션)
            map[i][1] = Integer.parseInt(st.nextToken()); // 몬스터 or 포션 공격력 증가량
            map[i][2] = Integer.parseInt(st.nextToken()); // 몬스터 or 포션 체력 증가량
        }

        long low = 1;
        long high = (long) 1e18; // 최대 체력 범위 설정
        long sol = high;

        // 이진 탐색으로 최소 체력 찾기
        while (low <= high) {
            long mid = (low + high) / 2;

            if (check(mid)) {
                sol = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(sol);
    }

    public static boolean check(long maxHp) {
        long currentHp = maxHp;
        long currentAttack = attack;

        for (int i = 0; i < N; i++) {
            int type = map[i][0];

            if (type == 1) { // 몬스터 전투
                long monsterAttack = map[i][1];
                long monsterHp = map[i][2];

                // 몬스터가 죽기까지 용사가 몇 번 공격해야 하는지 계산
                long attackCount = (monsterHp + currentAttack - 1) / currentAttack; // 올림 연산

                // 몬스터의 반격 횟수는 attackCount - 1
                currentHp -= monsterAttack * (attackCount - 1);

                // 용사가 죽으면 false 반환
                if (currentHp <= 0) {
                    return false;
                }

            } else { // 포션 사용
                int potionAttack = map[i][1];
                int potionHp = map[i][2];

                currentAttack += potionAttack; // 공격력 증가
                currentHp = Math.min(currentHp + potionHp, maxHp); // 체력 회복 (최대 체력 초과 방지)
            }
        }

        return true; // 끝까지 살아남았다면 true 반환
    }
}
