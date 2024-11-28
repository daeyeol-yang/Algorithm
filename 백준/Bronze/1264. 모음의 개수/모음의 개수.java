

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('e');
        hashSet.add('u');

        StringBuilder sb = new StringBuilder();
        while (true){
            String temp = br.readLine();
            if(temp.equals("#")){
                break;
            }
            int count =0;
            for (int i = 0; i < temp.length(); i++) {
                if(hashSet.contains((temp.charAt(i)+"").toLowerCase().charAt(0))){
                    count++;
                }
            }
            sb.append(count).append('\n');

        }

        System.out.println(sb);
    }
}
