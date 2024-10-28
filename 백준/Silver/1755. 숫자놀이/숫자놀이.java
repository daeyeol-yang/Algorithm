
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static String[] dir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dir = new String[] {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = start; i <=end ; i++) {
            hashMap.put(i,solution(i));
        }

        StringBuilder sb1 = new StringBuilder();

        ArrayList<Map.Entry> arrayList = new ArrayList<>(hashMap.entrySet());

        Collections.sort(arrayList, new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return o1.getValue().toString().compareTo(o2.getValue().toString());
            }
        });

        for (int i = 0; i < arrayList.size(); i++) {
            sb1.append(arrayList.get(i).getKey()).append(" ");
            if((i+1)%10==0){
                sb1.append('\n');
            }
        }

        System.out.println(sb1);





    }

    public static String solution(int num){
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(num);

        for (int i = 0; i < s.length(); i++) {
            sb.append(dir[Integer.parseInt(s.substring(i,i+1))]).append(" ");
        }
        return sb.toString();
    }
}
