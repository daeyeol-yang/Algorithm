
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            br.readLine();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int Sejun = Integer.parseInt(st.nextToken());
            int Sebi = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> SejunList = new ArrayList<>();
            ArrayList<Integer> SebiList = new ArrayList<>();
            ArrayList<Integer> SumList = new ArrayList<>();
            for (int j = 0; j < Sejun; j++) {
                SejunList.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Sebi; j++) {
                SebiList.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(SebiList);
            Collections.sort(SejunList);

            if (SebiList.get(SebiList.size() - 1) > SejunList.get(SejunList.size() - 1)) {
                sb.append("B");
            } else {
                sb.append("S");
            }

            sb.append('\n');


//            while (true){
//                for (int j = 0; j < SejunList.size(); j++) {
//                    SumList.add(SejunList.get(j));
//                }
//                for (int j = 0; j < SebiList.size(); j++) {
//                    SumList.add(SebiList.get(j));
//                }
//                if(SumList.size()==1){
//                    break;
//                }
//                Collections.sort(SumList);
//
//                int min = SumList.get(0);
//
//                if(SebiList.contains(min)){
//                    SebiList.remove((Integer) min);
//                }else{
//                    SejunList.remove((Integer) min);
//                }
//                SumList.clear();
//
//
//
//            }
//
//            if(SebiList.isEmpty()){
//                sb.append("S");
//            }else if(SejunList.isEmpty()){
//                sb.append("B");
//            }else{
//                sb.append("C");
//            }
//
//            sb.append('\n');
//        }
//
//        System.out.println(sb);
//    }
        }

        System.out.println(sb);
    }

}
