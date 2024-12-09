import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)){
                    return Math.abs(o1)-Math.abs(o2);
                } else if (Math.abs(o1)==Math.abs(o2)) {
                    return o1-o2;

                }else {
                    return -1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine());
            if(M==0){
                if(!priorityQueue.isEmpty()){
                    sb.append(priorityQueue.poll()).append('\n');
                }else {
                    sb.append("0").append('\n');
                }

            }else{
                priorityQueue.add(M);
            }

        }

        System.out.println(sb);
    }
}
