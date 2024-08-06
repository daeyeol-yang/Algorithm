import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int problem = Integer.parseInt(st.nextToken());

        int [][] A = new int[size+1][size+1];

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=size ; j++) {
                A[i][j]=Integer.parseInt(st.nextToken());

            }

        }
        int [][]D = new int[size+1][size+1];
        for (int i = 1; i <=size ; i++) {
            for (int j = 1; j <=size ; j++) {
                D[i][j]=D[i-1][j]+ D[i][j-1] -D[i-1][j-1]+A[i][j];
            }

        }

        for (int i = 0; i < problem; i++) {
            st= new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = D[x2][y2]-D[x1-1][y2]-D[x2][y1-1]+D[x1-1][y1-1];
            System.out.println(result);

        }
    }
}
