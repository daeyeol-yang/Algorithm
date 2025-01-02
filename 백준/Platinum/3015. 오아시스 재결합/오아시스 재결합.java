

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();
        long count =0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int temp =1;


            while(!stack.empty()&&stack.peek()[0]<=n){

                if(stack.peek()[0]==n){
                    temp += stack.peek()[1];
                }

                count+=stack.peek()[1];
                stack.pop();
            }

            if(!stack.empty()&&stack.peek()[0]>n){
                count++;
            }
            stack.push(new int[]{n,temp});

        }

        System.out.println(count);
    }
}
