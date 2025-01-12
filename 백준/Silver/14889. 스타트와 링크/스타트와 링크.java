import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int depth;
    static int N;

    static  int[][] arr;
    static boolean[] visited;

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        depth = N/2;
        StringTokenizer st;
        for (int i = 1; i <=N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=N ; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(1,0);


        System.out.println(min);

    }

    static void dfs(int index,int d){
        if(d==depth){
            diff();
            return;
        }

        for (int i = index; i <=N ; i++) {
            if(!visited[i]){
                visited[i]=true;
                dfs(i+1,d+1);
                visited[i]=false;
            }

        }


    }

    static void diff(){
        int start =0;
        int end =0;
        for (int i = 1; i <N ; i++) {
            for (int j = i+1; j <=N ; j++) {
                if(visited[i]&&visited[j]){
                    start+= arr[i][j];
                    start+= arr[j][i];
                }
                else if(!visited[i]&&!visited[j]){
                    end+= arr[i][j];
                    end+= arr[j][i];
                }
            }
        }
        if(min==0){
            System.out.println(0);
            System.exit(0);
        }

        min= Math.min(min,Math.abs(start-end));
    }
}
