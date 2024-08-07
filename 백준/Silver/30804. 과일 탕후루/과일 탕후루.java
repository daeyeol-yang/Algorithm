

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(st.nextToken());

        }

        int start =0;
        int end = 0;
        int max =0;


        while (end<N){
            int kind = hashMap.size();
            if(kind<=2){
                end++;
                int num = arr[end-1];
                if(hashMap.containsKey(num)){
                    hashMap.put(num,hashMap.get(num)+1);
                }else{
                    hashMap.put(num,1);
                }
                if(hashMap.size()<=2){
                    max = Math.max(max,sumNum(hashMap));
                }
            }else{
                int num = arr[start];
                start++;
                if(hashMap.get(num)>1){
                    hashMap.put(num,hashMap.get(num)-1);
                }else{
                    hashMap.remove(num);
                }
            }

        }

        System.out.println(max);

    }

    public static int sumNum(HashMap<Integer,Integer> hashMap){
        int sum =0;
        for(int value :hashMap.values()){
            sum+=value;
        }
        return sum;
    }
}
