

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Brick {
        int id;
        int weight;
        int height;
        int dimension;

        public Brick(int id,int weight, int height, int dimension) {
            super();
            this.id = id;
            this.weight = weight;
            this.height = height;
            this.dimension = dimension;
        }


    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringTokenizer st;

        Brick[] brickList  = new Brick[N];


        for(int i = 0; i<N ; i++) {
            st= new StringTokenizer(br.readLine());
            int dimension = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            brickList[i] = new Brick(i,weight, height, dimension);
        }

        Arrays.sort(brickList,(o1,o2)-> o2.dimension-o1.dimension);

//        for(Brick brick : brickList) {
//            System.out.println(brick.id + ";" +brick.dimension);
//        }


        int[] Lis = new int[N];
        int[] p = new int[N];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        int max =0;
        int lastIndex =0;
        for(int i = 0 ; i < N ;i++) {
            Lis[i] = brickList[i].height;
            for(int j = 0 ; j<i ;j++) {
                if(brickList[i].weight<brickList[j].weight && Lis[i] < Lis[j]+brickList[i].height) {

                    Lis[i] = Lis[j]+brickList[i].height;
                    p[i] = j;
                    //System.out.println("List[i]"+Lis[i] + "List[j]"+Lis[j] + "높이"+brickList[j].height);

                }
            }
            if(max<Lis[i]){
                max = Lis[i];
                lastIndex = i;
            }

        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(brickList[lastIndex].id + 1);
        int index = lastIndex;
        while (index != p[index]) {
            index = p[index];
            list.add(brickList[index].id + 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for(int n: list){
            sb.append(n).append('\n');
        }
        System.out.println(sb);
//        System.out.println(list);
//        System.out.println(Arrays.toString(Lis));
//        System.out.println(Arrays.toString(p));
//        System.out.println(max);


    }
}


