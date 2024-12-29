import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String problem = br.readLine();

            int length = Integer.parseInt(br.readLine());
            String list = br.readLine();
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            list = list.substring(1,list.length()-1);
            StringTokenizer st = new StringTokenizer(list,",");

            for (int j = 0; j < length; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(problem,deque);


        }
        System.out.println(sb);
    }

    public static void AC(String problem, Deque<Integer> deque){
        boolean reverse = false;
        for(char c : problem.toCharArray()){

            if(c == 'R'){
                reverse=!reverse;
                continue;
            }

            if (!reverse){
                if(deque.pollFirst()==null){
                    sb.append("error").append('\n');
                    return;
                }
            }else {
                if(deque.pollLast()==null){
                    sb.append("error").append('\n');
                    return;
                }
            }
        }
        print(deque, reverse);
    }

    private static void print(Deque<Integer> deque, boolean reverse) {
        sb.append('[');

        if(!deque.isEmpty()) {

            if (!reverse) {

                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');
    }


}
