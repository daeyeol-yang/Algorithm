

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count =0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                char a  = s.charAt(j);
                if(!stack.isEmpty()) {
                    if (stack.peek() != a) {
                        stack.add(a);
                    } else {
                        stack.pop();
                    }
                }else{
                    stack.add(a);
                }


            }
            if(stack.isEmpty()){
                count++;
            }
        }
        System.out.println(count);
    }
}
