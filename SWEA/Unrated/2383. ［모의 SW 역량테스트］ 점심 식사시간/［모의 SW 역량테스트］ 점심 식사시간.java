import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Person {
        int x, y;
        int[] arrival = new int[2];

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Stair {
        int x, y, time;

        public Stair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N, personCount;
    static List<Person> people;
    static Stair[] stairs;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            people = new ArrayList<>();
            stairs = new Stair[2];
            int stairIdx = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (val == 1) {
                        people.add(new Person(j, i));
                    } else if (val > 1) {
                        stairs[stairIdx++] = new Stair(j, i, val);
                    }
                }
            }

            personCount = people.size();
            for (Person p : people) {
                for (int s = 0; s < 2; s++) {
                    Stair stair = stairs[s];
                    p.arrival[s] = Math.abs(p.x - stair.x) + Math.abs(p.y - stair.y) + 1;
                }
            }

            answer = Integer.MAX_VALUE;
            dfs(0, new int[personCount]);
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int[] selected) {
        if (depth == personCount) {
            answer = Math.min(answer, simulate(selected));
            return;
        }

        selected[depth] = 0;
        dfs(depth + 1, selected);

        selected[depth] = 1;
        dfs(depth + 1, selected);
    }

    static int simulate(int[] selected) {
        List<Integer>[] arrivalList = new ArrayList[2];
        for (int i = 0; i < 2; i++) arrivalList[i] = new ArrayList<>();

        for (int i = 0; i < personCount; i++) {
            int stairChoice = selected[i];
            arrivalList[stairChoice].add(people.get(i).arrival[stairChoice]);
        }

        int[] maxEnd = new int[2];

        for (int s = 0; s < 2; s++) {
            List<Integer> arrivals = arrivalList[s];
            Collections.sort(arrivals);
            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 끝나는 시간

            for (int time : arrivals) {
                while (!pq.isEmpty() && pq.peek() <= time) {
                    pq.poll();
                }

                if (pq.size() < 3) {
                    pq.offer(time + stairs[s].time);
                    maxEnd[s] = Math.max(maxEnd[s], time + stairs[s].time);
                } else {
                    int earliest = pq.poll();
                    pq.offer(earliest + stairs[s].time);
                    maxEnd[s] = Math.max(maxEnd[s], earliest + stairs[s].time);
                }
            }
        }

        return Math.max(maxEnd[0], maxEnd[1]);
    }
}
