

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int count =0;




        for (int i = 0; i < N*2; i++) {
            String s = br.readLine();

            if(!set.contains(s)){
                set.add(s);
                queue.add(s);
            }else{
                if(!queue.isEmpty()) {
                    String temp = queue.peek();
                    if (!temp.equals(s)) {
                        count++;
                        queue.remove(s);
                    }else{
                        queue.poll();
                    }



                }
            }

        }
        System.out.println(count);
    }
}
