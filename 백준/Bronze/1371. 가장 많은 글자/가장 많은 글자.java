

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] arr = new int[50];
        String s;
        String sum = "";
        while ((s = br.readLine())!=null){
            sum+=s;
        }

        String s1 = sum.replace(" ","");

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)-'a']++;
        }

        int[] copy  = arr.clone();
        Arrays.sort(copy);

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==copy[copy.length-1]){
                sb.append((char)(i+'a'));
            }
        }

        System.out.println(sb);
    }




}
