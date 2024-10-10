import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> hashMap = new HashMap<>();

        // 숫자를 입력받아 빈도를 저장
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        // HashMap을 리스트로 변환하여 정렬
        ArrayList<Map.Entry<Long, Integer>> mapList = new ArrayList<>(hashMap.entrySet());

        // Comparator로 값(빈도)과 키(숫자)를 기준으로 정렬
        Collections.sort(mapList, (o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return Integer.compare(o2.getValue(), o1.getValue()); // 빈도 비교
        });

        // 가장 빈도가 높은 숫자를 출력
        System.out.println(mapList.get(0).getKey());
    }
}
