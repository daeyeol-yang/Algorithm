

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String temp = br.readLine();

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        int max=0;

        for (int i = 0; i < N; i++) {
            char c = temp.charAt(i);


            if(c=='('){
                stack.push(i);
            }

            if(c==')'){
                stack.pop();
                if(!stack.empty()){
                    int num = stack.peek();
                    max = Math.max(i-num, max);
                }else{
                    stack.push(i);
                }
            }

        }

        System.out.println(max);


    }
}
