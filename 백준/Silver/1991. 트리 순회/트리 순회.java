

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer>[] map;
    public static StringBuilder sb1 = new StringBuilder();
    public static StringBuilder sb2 = new StringBuilder();
    public static StringBuilder sb3 = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            map[i] = new  ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            char c1 = st.nextToken().charAt(0);
            char c2 = st.nextToken().charAt(0);

            int num = c-'A';
            if(c1!='.'){
                map[num].add(c1-'A');
            }else{
                map[num].add(-1);
            }

            if(c2!='.'){
                map[num].add(c2-'A');
            }else{
                map[num].add(-1);
            }

        }

        dfs(0);
        System.out.println(sb1);
        System.out.println(sb3);
        System.out.println(sb2);
    }

    public static void dfs(int node){
        if(node==-1){
            return;
        }

        sb1.append((char) (node+'A'));

        if(map[node].size()>0){
            dfs(map[node].get(0));
        }
        sb3.append((char)(node+'A'));

        if(map[node].size()>1){
            dfs(map[node].get(1));
        }

        sb2.append((char)(node+'A'));

    }
}
