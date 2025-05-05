

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        int sol =0;
        int value =1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c=='('){
                value *=2;
                stack.add(c);
            } else if (c=='[') {
                value *=3;
                stack.add(c);
            } else{
                if(!stack.isEmpty()){
                    char top = stack.peek();
                    if(c==')'){

                        if(top=='('){
                            if (s.charAt(i - 1) == '(') sol += value;
                            stack.pop();
                            value /= 2;
                        }else{
                            sol =0;
                            break;
                        }

                    }else{
                        if(top=='['){
                            if (s.charAt(i - 1) == '[') sol += value;
                            stack.pop();
                            value /= 3;
                        }else{
                            sol=0;
                            break;
                        }
                    }
                }else {
                    sol =0;
                    break;
                }
            }


        }

        System.out.println(!stack.isEmpty()?0:sol);
    }
}
