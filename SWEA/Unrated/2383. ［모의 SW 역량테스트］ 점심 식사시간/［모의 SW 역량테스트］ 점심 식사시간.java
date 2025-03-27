

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static class Person implements Comparable<Person>{
        int x;
        int y;
        int stairTime;
        int endTime;
        public Person(int x, int y) {
            super();
            this.x = x;
            this.y = y;

        }

        public void setStairTime(int time) {
            this.stairTime = time;
        }


        @Override
        public int compareTo(Person o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.stairTime, o.stairTime);
        }

    }

    static class Stair{
        int x;
        int y;
        int time;

        public Stair(int x, int y, int time) {
            super();
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static List<Person> copyPersonList(List<Person> original) {
        List<Person> copy = new ArrayList<>();
        for (Person p : original) {
            Person newP = new Person(p.x, p.y); // 위치 복사
            copy.add(newP);
        }
        return copy;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TESTCASE = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int testCase = 1 ; testCase <=TESTCASE ; testCase++) {

            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine());


            int[][] map = new int[N][N];

            List<Person> personList = new ArrayList<>();


            List<Stair> stairList = new ArrayList<>();

            for(int i = 0; i< N ; i++) {// 사람과 계단 입력값 정하기!!
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j< N ; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());


                    if(map[i][j] == 1) {
                        personList.add(new Person(j,i));
                    }else if(map[i][j] >1) {
                        stairList.add(new Stair(j,i,map[i][j]));
                    }
                }
            }

            int personSize = personList.size();


            int solTime =Integer.MAX_VALUE;
            for(int bit = 0 ; bit < (1<<personSize) ; bit++) {//비트 마스킹을 통해서 사람들이 각각 몇번 계단으로 갈지 정하는 코드!!
                List<Person> personCopy = copyPersonList(personList);


                List<Integer> stair1 = new ArrayList<>();//1번 계단으로 가는 사람들!!
                List<Integer> stair2 = new ArrayList<>();//2번 계단으로 가는 사람들!!


                for(int i = 0; i< personSize ;i++) {
                    if((bit&(1<<i))!=0) {
                        stair1.add(i);
                    }else {
                        stair2.add(i);
                    }

                }


                //사람마다 계단까지 도착하는 시간!!!
                Stair stairTemp1 = stairList.get(0);
                Stair stairTemp2 = stairList.get(1);


                PriorityQueue<Person> stair1Queue = new PriorityQueue<>();
                PriorityQueue<Person> stair2Queue = new PriorityQueue<>();
                //System.out.println(stair1);
                //System.out.println(stair2);

                for(int i =0 ; i< stair1.size() ; i++) {
                    int stairPerson = stair1.get(i);

                    Person person = personCopy.get(stairPerson);

                    int time = getDistance(person.x,person.y ,stairTemp1.x,stairTemp1.y)+1;

                    person.setStairTime(time);
                    stair1Queue.add(person);
                }


                Set<Person> stair1Set = new HashSet<>();

                int timeSol1 =0;

                while(true) {
                    timeSol1++;

                    List<Person> toRemove = new ArrayList<>();

                    for (Person p : stair1Set) {
                        p.endTime++;
                        if (p.endTime >= stairTemp1.time) {
                            //System.out.println("1에서 탈출 :" + p);

                            toRemove.add(p);
                        }
                    }

                    stair1Set.removeAll(toRemove);

                    if(stair1Queue.isEmpty()&&stair1Set.isEmpty()){

                        break;
                    }

                    //System.out.println("셋1 사이즈" + stair1Set.size());
                    //System.out.println("큐1 사이즈" + stair1Queue.size());

                    while(!stair1Queue.isEmpty() && timeSol1>= stair1Queue.peek().stairTime){
                        //System.out.println("hi");
                        if (stair1Set.size() < 3) {
                            stair1Set.add(stair1Queue.poll());
                        }else{
                            break;
                        }
                    }


                }

                //System.out.println(timeSol1);



                for(int i =0 ; i< stair2.size() ; i++) {
                    int stairPerson = stair2.get(i);

                    Person person = personCopy.get(stairPerson);

                    int time = getDistance(person.x,person.y ,stairTemp2.x,stairTemp2.y)+1;

                    person.setStairTime(time);
                    stair2Queue.add(person);
                }

                Set<Person> stair2Set = new HashSet<>();

                int timeSol2 =0;
                while(true) {
                    timeSol2++;

                    List<Person> toRemove = new ArrayList<>();

                    for (Person p : stair2Set) {
                        p.endTime++;
                        if (p.endTime >= stairTemp2.time) {
                            //System.out.println("2에서 탈출" +p);
                            toRemove.add(p);
                        }
                    }

                    stair2Set.removeAll(toRemove);

                   // System.out.println("time"+timeSol2);


                    if(stair2Queue.isEmpty()&&stair2Set.isEmpty()){
                        break;
                    }

                    while(!stair2Queue.isEmpty() && timeSol2>= stair2Queue.peek().stairTime){
                       // System.out.println("조건만족");
                        if (stair2Set.size() < 3) {
                            stair2Set.add(stair2Queue.poll());
                            //System.out.println("set 사이즈:"+ stair2Set.size());
                        }else{
                            //System.out.println("가득 참");
                            break;
                        }
                        //System.out.println("jo22");

                    }


                }


                //System.out.println("2에서 탈출시간" + timeSol2);

                solTime = Math.min(solTime, Math.max(timeSol1, timeSol2));

            }

            sb.append(solTime).append('\n');


        }

        System.out.println(sb);

    }

    public static int getDistance(int x, int y , int x1 , int y1) {
        return Math.abs(x-x1)+Math.abs(y-y1);
    }
}
