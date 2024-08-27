
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        char[][] arr = {{'A','C','A','G'},{'C','G','T','A'},{'A','T','C','G'},{'G','A','G','T'}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('A',0);
        hashMap.put('G',1);
        hashMap.put('C',2);
        hashMap.put('T',3);
        Stack<Character> stack = new Stack<>();
        String line = br.readLine();
        for (int i = 0; i < N; i++) {
            stack.push(line.charAt(i));
        }

        for (int i = 0; i < N-1; i++) {
            int col = hashMap.get(stack.pop());
            int row = hashMap.get(stack.pop());
            stack.push(arr[col][row]);
        }

        System.out.println(stack.pop());


    }
}
