import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.Arrays;

public class Main {
	
	
	public static boolean[] arr;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		isPrime(N);
		

		
		int start =0;
		int end =0;
		
		
		int sum =0;
		
		int count =0;
		
//		System.out.println(nextPrime(7));
//		
//		System.out.println(Arrays.toString(arr));
		
		
		
		while(end<=N) {
			
			
			
//			System.out.println("start"+ start);
//			System.out.println("end"+ end);
//			System.out.println(sum);
			if(sum<N) {
				end = nextPrime(end);
				sum+=end;
				
			}else if(sum>N) {
				sum -= start;
				start = nextPrime(start);
				
			}else {
				count++;
				end = nextPrime(end);
				sum+=end;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static int nextPrime(int n) {
		n+=1;
		while(n<arr.length) {
			if(arr[n]) {
				return n;
			}
			n++;	
		}
		return n;
	}
	
	public static void isPrime(int n) {
		arr  =  new boolean[n+1];
		for(int i =0 ; i<arr.length ; i++) {
			arr[i] = true;
		}
		
		arr[0] = arr[1] = false;
		
		for(int i=2 ; i<=Math.sqrt(arr.length); i++) {
			if(arr[i]) {
				for(int j = i*i; j<arr.length; j+=i) {
					arr[j] = false;
				}
			}
		}
		
	}

}
