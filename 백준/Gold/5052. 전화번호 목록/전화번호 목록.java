
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class TrieNode{
    HashMap<Character , TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}
public class Main {
    private static TrieNode root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TESTCASE = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < TESTCASE; testCase++) {
            root = new TrieNode();
            int N = Integer.parseInt(br.readLine());
            boolean isConsistent =true;
            for (int i = 0; i < N; i++) {
                if(!insert(br.readLine())){
                    isConsistent = false;
                }
            }
            sb.append(isConsistent? "YES" : "NO").append('\n');


        }
        System.out.println(sb);
    }

    public static boolean insert(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.isEndOfWord){
                return false;
            }
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        if(!curr.children.isEmpty()){
            return false;
        }
        curr.isEndOfWord = true;
        return true;
    }
}
