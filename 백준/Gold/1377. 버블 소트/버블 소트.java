

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Data[] arr = new Data[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Data(i,Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr);

        int max =0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i].index-i);
        }

        System.out.println(max+1);



    }



}

class Data implements Comparable<Data> {
    int index;
    int value;


    public Data(int index, int value) {
        super();
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Data o) {
        return this.value - o.value;
    }
}