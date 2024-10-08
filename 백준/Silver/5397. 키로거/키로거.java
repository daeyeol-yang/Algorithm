

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Character> arrayList;

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if(c=='>'){
                    if(!right.isEmpty()){
                        left.add(right.pop());
                    }

                }else if(c=='<'){

                    if(!left.isEmpty()){
                        right.add(left.pop());
                    }

                }else if(c=='-'){
                    if(!left.isEmpty()){
                        left.pop();
                    }

                }else{
                    left.add(c);

                }
            }
            while (!left.isEmpty()){
                sb.append(left.pop());
            }
            sb.reverse();
            while (!right.isEmpty()){
                sb.append(right.pop());
            }
            System.out.println(sb);


        }
    }

}
