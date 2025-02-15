

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int[] rotateArr = new int[N+K-1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine())-1;
        }

        int tempIndex = 0;

        for (int i = 0; i < rotateArr.length; i++) {
            rotateArr[i] = arr[tempIndex];
            tempIndex++;
            tempIndex%=arr.length;
        }

        //System.out.println(Arrays.toString(rotateArr));

        //HashMap<Integer,Integer> map = new HashMap<>();
        int[] menu = new int[d];
        //쿠폰 적용
        menu[c-1]++;

        //초기설정
        for (int i = 0; i < K; i++) {
            menu[arr[i]]++;
        }

        int type = check(menu);
        int max = check(menu);
        for (int i = K; i < rotateArr.length; i++) {
            if(menu[rotateArr[i]]==0){
                type+=1;
            }
            menu[rotateArr[i]]++;
            menu[rotateArr[i-K]]--;
            if(menu[rotateArr[i-K]]==0){
                type-=1;
            }
            max = Math.max(max, type);
        }

        System.out.println(max);


    }

    public static int check(int[] arr){
        int count =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0){
                count++;
            }
        }
        return count;
    }
}
