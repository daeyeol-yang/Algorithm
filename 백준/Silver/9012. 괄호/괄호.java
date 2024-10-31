

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            Stack<Character> stack = new Stack<>();


            for (int j = 0; j < temp.length(); j++) {


                char c = temp.charAt(j);


                if (c == '(') {
                    stack.add(c);
                } else {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '(') {
                            stack.pop();
                        }else {
                            stack.add(c);
                        }
                    } else{
                        stack.add(c);
                    }
                }

            }


            if(stack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }





    }
}
