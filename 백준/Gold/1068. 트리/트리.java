

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] visited;
    public static ArrayList<Integer>[] arrayLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arrayLists = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root =0;
        for (int i = 0; i < N; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            if(parentNode!=-1){

                arrayLists[parentNode].add(i);
            }else {
                root =i;
            }

        }



        visited = new boolean[N];

        int deleteNode = Integer.parseInt(br.readLine());

        if(deleteNode==root){
            System.out.println(0);
            System.exit(0);
        }else{

            dfs(deleteNode);
        }

        for (int i = 0; i < N; i++) {
            if(arrayLists[i].contains(deleteNode)){
                arrayLists[i].remove(Integer.valueOf(deleteNode));
            }
        }



        int count =0;
        for (int i = 0; i < N; i++) {
            if(!arrayLists[i].contains(-1)&&arrayLists[i].isEmpty()){
                count++;
            }
        }

       

        System.out.println(count);

    }

    public static void dfs(int node){
        visited[node] =true;
        for(int dNode : arrayLists[node]){
            if(!visited[dNode]){
                dfs(dNode);

            }

        }

        arrayLists[node].clear();
        arrayLists[node].add(-1);
    }
}
