

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Homework{
        int score;
        int time;

        public Homework(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long sumScore=0;
        Stack<Homework> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if(type==1){
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                stack.add(new Homework(score,time));
            }

            if(!stack.empty()){
                Homework now = stack.pop();
                now.time -=1;

                if(now.time==0){
                    sumScore+=now.score;
                }else{
                    stack.add(now);
                }
            }
        }

        System.out.println(sumScore);
    }
}
