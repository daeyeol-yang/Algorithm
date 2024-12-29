import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String s= st.nextToken();
            int n=0;
            if(!s.equals("all")&&!s.equals("empty")) {
                n = Integer.parseInt(st.nextToken());
            }

            switch (s){

                case "add":
                    set.add(n);
                    break;
                case "remove":
                    set.remove(n);
                    break;
                case  "check":
                    if(set.contains(n)){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                    break;
                case "toggle":
                    if(set.contains(n)){
                        set.remove(n);

                    }else{
                        set.add(n);
                    }
                    break;
                case "all":
                    set.clear();
                    for (int j = 1; j <=20 ; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;

            }
        }

        System.out.println(sb);



    }
}
