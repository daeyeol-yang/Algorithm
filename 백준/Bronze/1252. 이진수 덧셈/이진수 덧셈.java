

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String s1 = st.nextToken();

        // 두 문자열의 길이를 맞춤
        int size = Math.abs(s.length() - s1.length());
        String s2 = "";
        for (int i = 0; i < size; i++) {
            s2 = s2.concat("0");
        }
        if (s.length() > s1.length()) {
            s1 = s2.concat(s1);
        } else {
            s = s2.concat(s);
        }

        // 올바른 이진수 덧셈을 수행하기 위한 변수 설정
        ArrayList<Integer> list = new ArrayList<>();
        boolean carry = false;

        // 뒤에서부터 각 자리의 덧셈을 수행
        for (int i = s.length() - 1; i >= 0; i--) {
            int bit1 = s.charAt(i) - '0';
            int bit2 = s1.charAt(i) - '0';
            int sum = bit1 + bit2 + (carry ? 1 : 0);

            // 결과 비트와 캐리 설정
            if (sum >= 2) {
                list.add(sum % 2);
                carry = true;
            } else {
                list.add(sum);
                carry = false;
            }
        }
        // 마지막에 캐리가 남아있으면 추가
        if (carry) {
            list.add(1);
        }

        // 결과를 StringBuilder에 담기
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        // 결과에서 불필요한 앞쪽 0 제거
        int startIndex = 0;
        while (startIndex < sb.length() - 1 && sb.charAt(startIndex) == '0') {
            startIndex++;
        }

        // 결과 출력
        System.out.println(sb.substring(startIndex));
    }
}
