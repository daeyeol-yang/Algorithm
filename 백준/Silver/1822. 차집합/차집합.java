
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> arrayList1 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrayList1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(arrayList1.contains(num)){
                arrayList1.remove(num);
            }
        }


        ArrayList<Integer> sol = new ArrayList<>(arrayList1);




        Collections.sort(sol);

        StringBuilder sb = new StringBuilder();

        if(sol.isEmpty()){
            sb.append(0);
        }else{
            sb.append(sol.size()).append('\n');
            for (int i = 0; i < sol.size(); i++) {
                sb.append(sol.get(i)).append(" ");
            }
        }

        System.out.println(sb);




    }
}
