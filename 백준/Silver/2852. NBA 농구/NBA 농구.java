

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 0);
        hashMap.put(2, 0);

        int aCount = 0;
        int bCount = 0;
        int time =0;

        int prev_time = 0;

        int winTeam = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());

            time = stringToInt(st.nextToken());



            hashMap.put(team, hashMap.get(team) + 1);

            if(hashMap.get(1)>hashMap.get(2)){
                if(winTeam==1){
                    aCount+=time-prev_time;
                }
                winTeam =1;
            }else if(hashMap.get(1).equals(hashMap.get(2))){
                if(winTeam==1){
                    aCount+=time-prev_time;
                } else {
                    bCount+=time-prev_time;
                }
                winTeam =0;
            }else{
                if(winTeam==2){
                    bCount+=time-prev_time;
                }
                winTeam =2;
            }

            prev_time=time;





//
//            if (hashMap.get(1) > hashMap.get(2)) {
//                if (team == 1) {
//                    if (winTeam != 1) {
//                        prev_time = time;
//                        winTeam = 1;
//                    }
//                }
//
//            } else if (hashMap.get(1).equals(hashMap.get(2))) {
//                if (team == 1) {
//                    bCount += time - prev_time;
//                    prev_time = time;
//                } else {
//                    aCount += time - prev_time;
//                    prev_time = time;
//                }
//                winTeam=0;
//            } else {
//                if (team == 2) {
//                    if (winTeam != 2) {
//                        prev_time = time;
//                        winTeam = 2;
//                    }
//
//                }
//
//
//            }
//
//
//
       }

        if (winTeam==1) {
            aCount += 48 * 60 - prev_time;
        }
        if (winTeam==2) {
            bCount += 48 * 60 - prev_time;
        }

        System.out.println(intToString(aCount));
        System.out.println(intToString(bCount));
    }

    public static int stringToInt(String s){
        StringTokenizer st = new StringTokenizer(s,":");

        int bun = Integer.parseInt(st.nextToken());
        int cho = Integer.parseInt(st.nextToken());

        return bun * 60 + cho;
    }

    public static String intToString(int N){
        StringBuilder sbSi = new StringBuilder();
        StringBuilder sbBun = new StringBuilder();

        String si =String.valueOf(N/60);
        String bun =String.valueOf(N%60);

        for (int i = 0; i < 2-si.length(); i++) {
            sbSi.append(0);
        }
        sbSi.append(si);

        for (int i = 0; i < 2-bun.length(); i++) {
            sbBun.append(0);
        }
        sbBun.append(bun);


        return sbSi.append(":").append(sbBun).toString();



    }
}
