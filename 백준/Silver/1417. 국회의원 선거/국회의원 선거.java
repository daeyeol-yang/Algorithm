

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int da = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < N-1; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }
        int count =0;

        while (!priorityQueue.isEmpty()){
            int max = priorityQueue.poll();

            if(max<da){
                break;
            }else{
                priorityQueue.add(max-1);
                count++;
                da++;
            }



        }

        System.out.println(count);




    }
}
