

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;

    public static char[] opArr;

    public static ArrayList<int[]> arrayList;

    public static ArrayList<int[]> sol;

    public static void main(String[] args) throws IOException {
        arr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        opArr = new char[N];
        arrayList = new ArrayList<>();
        sol = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            opArr[i] = st.nextToken().charAt(0);
        }

        go(10, N + 1, 0);


        check();

//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(Arrays.toString(arrayList.get(i)));
//        }
        StringBuilder sb = new StringBuilder();

//        for (int i = 0; i < sol.size(); i++) {
//            System.out.println(Arrays.toString(sol.get(i)));
//        }

        Collections.sort(sol, (a, b) -> {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return Integer.compare(a[i], b[i]);
                }
            }
            return 0;
        });



        for (int i = 0; i < N + 1; i++) {
            sb.append(sol.get(sol.size()-1)[i]);
        }
        sb.append('\n');
        for (int i = 0; i < N + 1; i++) {
            sb.append(sol.get(0)[i]);
        }
        sb.append('\n');



        System.out.println(sb);


    }

    public static void check() {

        for (int[] arr2 : arrayList) {
            boolean check = true;
            for (int j = 0; j < opArr.length; j++) {
                if (!check1(arr2[j], opArr[j], arr2[j + 1])) {
                    check = false;
                    break;
                }

            }
            if (check) {
                sol.add(arr2);
            }
        }
    }

    public static boolean check1(int a, char c, int b) {
        if (c == '<') {
            return a < b;
        } else {
            return a > b;
        }
    }

    public static void go(int n, int r, int depth) {
        if (r == depth) {
            arrayList.add(Arrays.copyOf(arr, arr.length));
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(i, depth);
            go(n, r, depth + 1);
            swap(depth, i);
        }
    }

    public static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
