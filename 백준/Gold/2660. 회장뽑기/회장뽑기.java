

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer>[] arrayLists;
    public static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        arrayLists = new ArrayList[size];

        for (int i = 0; i < size; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(A==-1 && B==-1){
                break;
            }

            arrayLists[A-1].add(B-1);
            arrayLists[B-1].add(A-1);

        }

        int[] score = new int[size];

        int max_score = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            map = new int[size];
            bfs(i);
            Arrays.sort(map);
            max_score=Math.min(map[size-1],max_score);
            score[i]=map[size-1];
        }


        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        int count =0;
        for (int i = 0; i < size; i++) {
            if(score[i]==max_score){
                count++;
                sb1.append(i+1).append(" ");
            }
        }
        sb.append(max_score-1).append(" ").append(count)
                .append('\n')
                .append(sb1);

        System.out.println(sb);
    }

    public static void bfs(int num){
        map[num]+=1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int n : arrayLists[now]){
                if(map[n]==0){
                    map[n]=map[now]+1;
                    queue.add(n);
                }
            }

        }

    }
}
