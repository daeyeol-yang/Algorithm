import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int result =0;
    String s = sc.next();
    for (int i = 0; i < n; i++) {
        
        int c= s.charAt(i)-'0';
        result+=c;
        
        
    }
    System.out.println(result);

    }
    
}