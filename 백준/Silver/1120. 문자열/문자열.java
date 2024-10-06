
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int size = B.length()- A.length();
        int count=0;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < size+1; i++) {
            String temp = B.substring(i,A.length()+i);
            count=0;
            for (int j = 0; j < A.length() ; j++) {
                if(temp.charAt(j)!=A.charAt(j)){
                    count++;
                }

            }
            minCount = Math.min(count,minCount);

        }
        System.out.println(minCount);
    }
}
