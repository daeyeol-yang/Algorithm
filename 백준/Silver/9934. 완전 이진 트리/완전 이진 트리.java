import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] arrayLists;

    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arrayLists = new ArrayList[K+2];
        for (int i = 1; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        int size = (int) (Math.pow(2,K)-1);

        arr = new int[size+1];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }



        go(0,size,1);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < K+1; i++) {
            for (int j = 0; j < arrayLists[i].size(); j++) {
                sb.append(arrayLists[i].get(j)).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    public static void go(int s,int size, int depth){
        if(s>size){
            return;
        }
        if(s==size){
            arrayLists[depth].add(arr[s]);
            return;
        }
        int mid = (s+size)/2;

        arrayLists[depth].add(arr[mid]);



        go(s,mid-1,depth+1);

        go(mid+1,size,depth+1);



    }
}
