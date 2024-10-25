import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static Set<Character> mo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mo = new HashSet<>();
        mo.add('a');
        mo.add('e');
        mo.add('i');
        mo.add('o');
        mo.add('u');
        StringBuilder sb = new StringBuilder();

        while(true){
            String temp= br.readLine();
            if(temp.equals("end")){
                break;
            }
           sb.append("<").append(temp).append(">").append(" is ");
           if(check1(temp)&&check2(temp)&&check3(temp)){
            sb.append("acceptable.");
           }else{
               sb.append("not acceptable.");

           }

            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static boolean check1(String s){
        for (int i = 0; i < s.length(); i++) {
            if(mo.contains(s.charAt(i))){
               return true;
            }
        }
        return false;
    }

    public static boolean check2(String s){
        int moCount =0;
        int jaCount =0;
        for (int i = 0; i < s.length(); i++) {
            if(mo.contains(s.charAt(i))){
              moCount++;
              jaCount=0;
            }else{
                jaCount++;
                moCount=0;
            }

            if(jaCount>=3||moCount>=3){
                return false;
            }
        }
        return true;

    }

    public static boolean check3(String s){
        char prev_c =' ';
        for (int i = 0; i < s.length(); i++) {
            char now_c = s.charAt(i);

            if(now_c==prev_c){

                if(prev_c!='e'&&prev_c!='o'){
                    return false;
                }
            }

            prev_c = now_c;
        }

        return true;

    }
}
