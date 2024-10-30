import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack myStack = new Stack<>();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            try {


                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '(') {
                        myStack.push(s.charAt(j));
                    } else if (s.charAt(j) == ')') {
                        myStack.pop();
                    } else {
                        continue;
                    }
                }


            if(myStack.isEmpty()){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
            }catch (EmptyStackException e){
                System.out.println("NO");
            }
            myStack.clear();

        }
    }
}
