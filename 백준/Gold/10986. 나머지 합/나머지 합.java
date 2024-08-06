import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int problem = sc.nextInt();
        int remain = sc.nextInt();
        long []S = new long[problem];
        long [] C = new long[remain];
        long answer =0;
        S[0] = sc.nextInt();
        for (int i = 1; i <problem ; i++) {
            S[i]=S[i-1]+sc.nextInt();
        }

        for (int i = 0; i < problem; i++) {
            int remainder = (int)(S[i]%remain);

            if(remainder==0)answer++;

            C[remainder]++;
        }
        for (int i = 0; i < remain; i++) {
            if(C[i]>1)
            {
                answer = answer + C[i]*(C[i]-1)/2;
            }
        }
        System.out.println(answer);
    }
}
