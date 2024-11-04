

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int[] arr = new int[N];
        int[] sol = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        boolean check = false;
//
//        for (int i = 0; i < N; i++) {
//            check = false;
//            for (int j = i+1; j <N ; j++) {
//                if(arr[i]<arr[j]){
//                    sb.append(arr[j]).append(" ");
//                    check = true;
//                    break;
//                }
//            }
//            if(!check){
//                sb.append(-1).append(" ");
//            }
//        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if(stack.isEmpty()){
                stack.add(i);
            }else{
                int num = arr[i];

                while (!stack.isEmpty()){
                    if(arr[stack.peek()]<num){
                        sol[stack.peek()]=num;
                        stack.pop();


                    }else{

                        break;
                    }
                }
                stack.add(i);


            }
        }

        while (!stack.isEmpty()){
            sol[stack.pop()]=-1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(sol[i]).append(" ");
        }
        System.out.println(sb);

    }
}
