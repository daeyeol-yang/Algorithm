

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            if(s.equals(".")){
                break;
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(c=='('){
                    stack.add(c);
                }

                if(c=='['){
                    stack.add(c);
                }

                if(c==')'){
                    if(!stack.isEmpty()){
                        if(stack.peek()=='('){
                            stack.pop();
                        }else{
                            stack.add(c);
                        }
                    }else{
                        stack.add(c);
                    }
                }

                if(c==']'){
                    if(!stack.isEmpty()){
                        if(stack.peek()=='['){
                            stack.pop();
                        }else{
                            stack.add(c);
                        }
                    }else{
                        stack.add(c);
                    }
                }

            }

            if(stack.isEmpty()){
                sb.append("yes");
            }else{
                sb.append("no");
            }
            sb.append('\n');


        }

        System.out.println(sb);
    }
}
