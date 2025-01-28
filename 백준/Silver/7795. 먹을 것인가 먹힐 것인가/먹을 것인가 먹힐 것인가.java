

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int testcase = 0; testcase < testCase; testcase++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arrA = new int[N];
            int[] arrB = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            //x라는 값 미만의 갯수가 몇개일까?? -> upperbound , lowerbound


            int count =0;
            for (int i = 0; i < N; i++) {
                int gijun = arrA[i];

                count += lowerBound(arrB , gijun);
            }
            sb.append(count).append('\n');

        }

        System.out.println(sb);
    }

    public static int lowerBound(int [] arr, int key){
        int low =0;
        int high = arr.length;

        while(low<high){
            int mid = (low+high)/2;

            if(arr[mid] < key){
                low = mid +1;
            }else {
                high = mid;
            }

        }

        return low;


    }
}
