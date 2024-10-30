

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> arrayList = new ArrayList<>();

        String num = "";
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();

            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);

                if('0'<=c&&c<='9'){
                    num+=c;
                }else{
                    if(!num.equals("")){
                        arrayList.add(removeZero(num));
                    }
                    num = "";
                }
            }
            if(!num.equals("")){
                arrayList.add(removeZero(num));
            }
            num = "";



        }


        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return o1.length()-o2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i)).append('\n');
        }

        System.out.println(sb);
    }

    public static String removeZero(String s){
        int index =0;
        boolean check = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='0'){
                index=i;
                check =true;
                break;
            }
        }




        return !check?"0":s.substring(index);

    }
}
