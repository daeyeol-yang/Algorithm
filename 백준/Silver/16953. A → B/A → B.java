import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] visited;
    public static long first,second;
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        first = Long.parseLong(st.nextToken());
        second = Long.parseLong(st.nextToken());


        System.out.println(bfs(first));


    }

    public static int bfs(long a){
        Queue<Long> queue = new LinkedList<>();
        queue.offer(a);

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long num = queue.poll();
                if(num==second){
                    return count+1;
                }
                if(A(num)<=second){
                    queue.add(A(num));

                }

                if(B(num)<=second){
                    queue.add(B(num));
                }

            }
            count++;


//            if(A(num)<=second&&visited[(int)A(num)]==0){
//                queue.add(A(num));
//                visited[(int)A(num)]=visited[(int)num]+1;
//            }
//
//            if(B(num)<=second&&visited[(int)B(num)]==0){
//                queue.add(B(num));
//                visited[(int)B(num)]=visited[(int)num]+1;
//            }
        }
        return -1;


    }

    public static long A(long a){
        return 2*a;
    }

    public static long B(long a){
        return a*10+1;
    }
}
