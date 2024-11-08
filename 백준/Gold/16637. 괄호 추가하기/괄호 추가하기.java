

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static char[] op;
    public static int[] nums;

    public static int maxResult=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String temp = br.readLine();
        op = new char[N/2];
        nums = new int[N/2+1];
        int opIndex =0;
        int numIndex =0;
        for (int i = 0; i < N; i++) {
            if(i%2==1){
                op[opIndex] = temp.charAt(i);
                opIndex++;
            }else{
                nums[numIndex] = temp.charAt(i)-'0';
                numIndex++;
            }
        }

        go(0,nums[0]);

        System.out.println(maxResult);

    }

    public static void go(int index,int result){
        if(index==nums.length-1){
            maxResult = Math.max(maxResult,result);
            return;
        }


        go(index+1,operate(op[index],result,nums[index+1]));


        if(index+2<= nums.length-1) {
            int temp = operate(op[index + 1], nums[index + 1], nums[index + 2]);

            go(index + 2, operate(op[index], result, temp));
        }



    }

    public static int operate(char op , int left, int right){


        if(op=='+'){
            return left+right;
        }else if(op=='-'){
            return left-right;
        } else if (op == '*') {
            return left*right;
        }

        return 0;
    }
}
