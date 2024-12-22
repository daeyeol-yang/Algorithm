

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int[] team;

    public static boolean[] visited;

    public static ArrayList<Integer>[] map;

    public static int[] teamTempScore;

    public static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        score = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        map = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }

        // 입력값 받아서 map에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int N1 = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N1 ; j++) {
                int num = Integer.parseInt(st.nextToken())-1;
                map[i].add(num);
                map[num].add(i);
            }
        }

        int difTeamScore = Integer.MAX_VALUE;

        // 비트마스킹 시작

        for (int i = 1; i < (1<<N)-1; i++) {
            //팀과 방문 기록은 항상 초기화!!
            team = new int[N];
            visited = new boolean[N];
            int team0Start =-1;
            int team1Start = -1;
            teamTempScore = new int[2];

            // 선거 구마다(DFS)로 시작할 시작점 설정
            for (int j = 0; j < N; j++) {
                if((i&(1<<j))!=0){
                    team[j] = 1;
                    team1Start = j;
                }else{
                    team[j] = 0;
                    team0Start = j;
                }
            }

            dfs(team0Start,0);
            dfs(team1Start,1);

            boolean componentCheck = false;

            for (int j = 0; j < N; j++) {

                if(!visited[j]){
                    componentCheck = true;
                    break;
                }
            }

            if(!componentCheck){
                difTeamScore = Math.min(difTeamScore,Math.abs(teamTempScore[0]-teamTempScore[1]));
            }
            
        }

        StringBuilder sb = new StringBuilder();

        if(difTeamScore==Integer.MAX_VALUE){
            sb.append(-1);
        }else{
            sb.append(difTeamScore);
        }

        System.out.println(sb);

    }

    public static void dfs(int node , int teamNum){
        visited[node] = true;
        teamTempScore[teamNum] += score[node];

        for(int next_node : map[node]){
            if(!visited[next_node]&& team[next_node] == teamNum ){
                dfs(next_node, teamNum);
            }
        }
    }
}
