

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }


        HashSet<String> hashSet = new HashSet<>();
        int sol =0;

        for (int i = arr[0].length()-1; i >=0 ; i--) {

            for (int j = 0; j < N; j++) {
                hashSet.add(arr[j].substring(i,arr[0].length()));
            }

            if(hashSet.size()==N){
                sol = arr[0].length() - i;
                break;
            }
            hashSet.clear();
        }

        System.out.println(sol);
    }
}
