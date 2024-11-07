

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static int[] arr1;

    public static int[][][] visited = new int[61][61][61];

    public static ArrayList<int[]> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr1 = new int[]{0,0,0};
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[]{9,3,1};

        shuffle(3,3,0);

        bfs(arr1);

//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(Arrays.toString(arrayList.get(i)));
//        }

        System.out.println(visited[0][0][0]-1);






    }

    public static void bfs(int[] arr){
        visited[arr[0]][arr[1]][arr[2]] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{arr[0],arr[1],arr[2]});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int now_0 = now[0];
            int now_1 = now[1];
            int now_2 = now[2];

//            if(now_0==0&&now_1==0&&now_2==0){
//                return;
//            }

            for (int i = 0; i < arrayList.size(); i++) {
                int next_0 = Math.max(0, now_0 - arrayList.get(i)[0]);
                int next_1 = Math.max(0, now_1 - arrayList.get(i)[1]);
                int next_2 = Math.max(0, now_2 - arrayList.get(i)[2]);

                if(visited[next_0][next_1][next_2]==0){
                    visited[next_0][next_1][next_2]= visited[now_0][now_1][now_2]+1;
                    queue.add(new int[]{next_0,next_1,next_2});
                }


            }
        }
    }


    public static void shuffle(int n,int r,int depth){
        if(r==depth){
            arrayList.add(arr.clone());
            return;
        }

        for (int i = depth; i <n ; i++) {
            swqp(i,depth);
            shuffle(n,r,depth+1);
            swqp(i,depth);
        }



    }

    public static void print(){
        System.out.println(Arrays.toString(arr));
    }



    public static void swqp(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}
