

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;

    public static int[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        word = new int[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                word[i] |= (1<<(c-'a'));
            }
            
        }

        System.out.println(go(0,K,0));
    }

    public static int go(int index, int k , int mask){
        if(k<0){
            return 0;
        }
        if(index==26){
            return count(mask);
        }
        int ret = go(index+1,k-1,mask|(1<<index));

        if(index!='a'-'a' && index!='n'-'a' && index != 't'-'a' && index != 'i' - 'a' && index !='c' - 'a'){
            ret = Math.max(ret , go(index+1, k , mask));
        }

        return ret;

    }

    public static int count(int mask){
        int sol = 0;
        for (int i = 0; i < N; i++) {
            int problem =  word[i];
            if((mask&problem)==problem){
                sol++;
            }

        }

        return sol;
    }
}
