

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, String> hashMap2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            hashMap1.put(temp, i);
            hashMap2.put(i, temp);

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            char c = s.charAt(0);

            if ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z') {
                sb.append(hashMap1.get(s)).append('\n');
            } else {
                sb.append(hashMap2.get(Integer.parseInt(s))).append('\n');

            }

        }
        System.out.println(sb);
    }
}


//        String[] arr = new String[N];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = br.readLine();
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < M; i++) {
//            String s = br.readLine();
//            char c = s.charAt(0);
//
//            if('a'<=c && c<='z' || 'A'<=c && c<='Z'){
//                for (int j = 0; j < arr.length; j++) {
//                    if(arr[j].equals(s)){
//                        sb.append(j+1).append('\n');
//                        break;
//                    }
//                }
//
//            }else{
//                sb.append(arr[Integer.parseInt(s)-1]).append('\n');
//            }
//        }
//
//        System.out.println(sb);
//}
//}
