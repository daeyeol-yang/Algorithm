

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int size = s.length();
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(s.charAt(i));
        }

        Collections.sort(arrayList);

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();


        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            hashMap.put(arrayList.get(i), hashMap.getOrDefault(arrayList.get(i), 0) + 1);
        }

        char midCharacter = ' ';
        int count = 0;

        for (Map.Entry<Character, Integer> hashMap1 : hashMap.entrySet()) {
            if (hashMap1.getValue() % 2 != 0) {
                count++;
                midCharacter = hashMap1.getKey();
            }
        }


        if (count > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        } else if(count==1){
            arrayList.remove(arrayList.indexOf(midCharacter));
        }

        for (int i = 0; i < arrayList.size(); i++) {
            left.append(arrayList.get(i));
            right.append(arrayList.get(i));
            i++;
        }

        if(count==1){
            left.append(midCharacter).append(right.reverse());
        }else{
            left.append(right.reverse());
        }
        System.out.println(left);


    }
}
