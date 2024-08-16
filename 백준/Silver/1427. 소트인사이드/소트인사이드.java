import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<Integer> mylist = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            mylist.add(Integer.parseInt(s.substring(i,i+1)));
        }
        Collections.sort(mylist,Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < mylist.size(); i++) {
            sb.append(mylist.get(i));
        }

        System.out.println(sb);
    }
}
