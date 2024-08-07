

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start =1;
        int end =1;
        int count =1;
        int sum=1;
        while (end!=N){
            if(sum==N){
                count++;
                end++;
                sum+=end;
            } else if (sum<N) {
                end++;
                sum+=end;
            }else{
                sum-=start;
                start++;
            }
        }

        System.out.println(count);
//        Scanner sc= new Scanner(System.in);
//        int N= sc.nextInt();
//        int count =1;
//        int start_index =1;
//        int end_index=1;
//        int sum=1;
//        while(end_index!=N){
//            if(sum==N){
//                count++;
//                end_index++;
//                sum=sum+end_index;
//            } else if (sum>N) {
//                sum=sum-start_index;
//                start_index++;
//
//            }else{
//                end_index++;
//                sum=sum+end_index;
//            }
//        }
//        System.out.println(count);
    }
}
