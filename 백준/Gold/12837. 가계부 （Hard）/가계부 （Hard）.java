

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] segTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        segTree = new long[4*N];

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if(type==1){
                int day = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                updateSeg(1,1,N,day , value);
            }else{
                int start =  Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                System.out.println(
                querySeg(1,1,N,start , end));
            }

        }
    }

    public static long querySeg(int index , int s , int e , int ts ,int te){
        if(ts<= s && e <= te){
            return segTree[index];
        }

        if(e < ts || te < s ){
            return 0;
        }

        int mid = (s+e)/2;
        long left = querySeg(index*2 , s , mid , ts , te);
        long right = querySeg(index*2+1 , mid+1 , e , ts, te);

        return left+right;
    }

    public static long updateSeg(int index ,int s, int e , int targetIndex , int targetValue){
        if(s == targetIndex && e == targetIndex){
            segTree[index] += targetValue;
            return segTree[index];
        }

        if(targetIndex <s || targetIndex >e){
            return segTree[index];
        }

        int mid = (s+e)/2;
        long left = updateSeg(index*2 , s , mid, targetIndex,targetValue);
        long right = updateSeg(index*2+1, mid+1, e, targetIndex,targetValue);
        segTree[index] = left+right;
        return segTree[index];
    }
}
