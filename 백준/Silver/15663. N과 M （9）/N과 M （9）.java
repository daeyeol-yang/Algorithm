
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr, sol;


    public static ArrayList<int[]> arrayList;

    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sol = new int[R];
        visited = new boolean[N];

        arrayList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        go(N,R,0);

        StringBuilder sb = new StringBuilder();

        for(int[] temp : arrayList){
            for(int num : temp){
                sb.append(num).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
    public static void go(int N ,int R, int depth){
        if(R == depth){
            if(true) {
                arrayList.add(sol.clone());
            }
            return;

        }
        int before =0;
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                if(before != arr[i]){
                    visited[i] = true;
                    sol[depth] = arr[i];
                    before = arr[i];
                    go(N,R,depth+1);
                    visited[i] = false;
                }

            }
        }
    }

    public static boolean check(){
        int count =0;
        for(int[] temp : arrayList){
            boolean check =false;
            for (int i = 0; i < temp.length; i++) {
                if(sol[i]!=temp[i]){
                    check=true;
                    break;
                }
            }
            if(!check){
                count++;
            }
        }
        if(count>0){
            return false;
        }
        return true;
    }
}
