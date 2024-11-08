

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] map;
    public static int[] nextArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Soo = Integer.parseInt(st.nextToken());
        int Dong = Integer.parseInt(st.nextToken());

        map = new int[200001];
        nextArray = new int[200001];


        bfs(Soo);

        int num = map[Dong]-1;
        StringBuilder sb = new StringBuilder();
        sb.append(num).append('\n');



//        ArrayList<Integer> arrayList = new ArrayList<>();
//        int i = Dong;
//        while (true){
//            if(nextArray[i]==0){
//                break;
//            }
//            arrayList.add(nextArray[i]);
//
//            i = nextArray[i];
//
//        }
//
//        for (int j = arrayList.size()-1; j >=0 ; j--) {
//            sb.append(arrayList.get(j)).append(" ");
//        }
//        sb.append(Dong);
//
//
//
//
//        System.out.println(sb);

        ArrayList<Integer> path = new ArrayList<>();
        for (int i = Dong; i != Soo; i = nextArray[i]) {
            path.add(i);
        }
        path.add(Soo); // 시작 위치 추가

        // 경로를 뒤집어서 출력
        for (int j = path.size() - 1; j >= 0; j--) {
            sb.append(path.get(j)).append(" ");
        }

        System.out.println(sb);



    }

    public static void bfs(int index){
        map[index] = 1;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(index);

        while (!queue.isEmpty()){
            int now = queue.poll();

            for(int next : new int[]{now+1,now-1,now*2}){

                if(0<=next && next<map.length){
                    if(map[next]==0){

                        queue.add(next);
                        map[next]= map[now]+1;
                        nextArray[next] = now;
                    }

                }
            }
        }

    }
}
