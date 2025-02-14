

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static int D,W,K;

    public static int[][] map;

    public static boolean[] visited;
    //public static ArrayList<Integer> combiList;

    public static boolean solSuccess;

    public static int min;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int testCase = 1 ; testCase<=testCases ; testCase++) {
            sb.append("#").append(testCase).append(" ");

            st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            solSuccess = false;

            map = new int[D][W];

            for(int i=0 ; i < D ; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j<W ; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                }
            }


            min =Integer.MAX_VALUE;

            if(successCheck()){
                sb.append(0).append('\n');
            }else {

//                for (int medicine = 0; medicine < K; medicine++) {
//                    //combiList = new ArrayList<>();
//                    visited = new boolean[D];
//                    combi1(medicine, 0);
//                    if (solSuccess) {
//                        sol = medicine;
//                        break;
//                    }
//                }

                combi1(0,0);

                if (min == Integer.MAX_VALUE) {
                    min = K;
                }

                sb.append(min).append('\n');
            }


        }
        System.out.println(sb);

    }

//  public static void combi(int maxCount,int index) {
//
//      if(solSuccess) {
//          return;
//      }
//
//      if(index==maxCount) {
//          System.out.println(combiList);
//          go1(0);
//          return;
//      }
//
//      for(int num=index ; num < D ; num++) {
//          if(!combiList.contains(num)) {
//          combiList.add(num);
//          combi(maxCount,index+1);
//          combiList.remove(Integer.valueOf(num));
//          }
//
//      }
//
//
//
//  }

    public static void combi1(int maxCount , int num) {

        if(successCheck()) {
           
            min = Math.min(min,maxCount);


            return;
        }

        if(num>=D){
            return;
        }

        if(maxCount>=K){
            return;
        }


        int copy[] = map[num].clone();

        combi1(maxCount,num+1);

        paint(num,0);
        combi1(maxCount+1,num+1);
        map[num] = copy.clone();

        paint(num,1);
        combi1(maxCount+1,num+1);
        map[num] = copy.clone();


    }

//  public static void go1(int index) {
//
//      if(combiList.size()==index) {
//          if(successCheck()) {
//              solSuccess = true;
//
//          }
//          return;
//      }
//
//      if(solSuccess) {
//          return;
//      }
//      int row = combiList.get(index);
//      int copy[] = map[row].clone();
//      paint(row,0);
//      go1(index+1);
//      map[row] = copy.clone();
//      paint(row,1);
//      go1(index+1);
//      map[row] = copy.clone();
//
//  }
//



    public static void paint(int index , int num) {
        for(int i=0; i<W ; i++) {
            map[index][i] = num;
        }

    }


    public static boolean successCheck() {

        for(int i = 0 ; i < W ; i++) {
            if(!checkColumn(i)) {
                return false;
            }
        }
        return true;

    }


    public static boolean checkColumn(int index) {
        int count0=0;
        int count1=0;

        for(int i =0; i< D ; i++) {
            if(map[i][index]==0) {
                count1 = 0;
                count0++;
                if(count0>=K) {
                    return true;
                }
            }else {
                count0=0;
                count1++;
                if(count1>=K) {
                    return true;
                }
            }

        }
        return false;

    }

}
