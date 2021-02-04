package com.test02;

import com.compare.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MTest02 {

    public static void main(String[] args) {

        List<Score> list = new ArrayList<Score>();

        Score hong = new Score();
        hong.setName("홍길동");
        hong.setKor(100);
        hong.setMath(39);
        hong.setEng(78);
        list.add(hong);

        Score lee = new Score("이순신", 79, 100, 78);
        list.add(lee);

        list.add(new Score("김선달", 50, 90, 100));

        System.out.println(list);
        System.out.println("-------------------------------");
        Collections.sort(list, new MySortTest());
        System.out.println(list);
    }

}

    /*
       + : 앞의 인자가 더 큰값
       0 : 같은 값
       - : 뒤의 인자가 더 큰값
     */
//하나의 파일에서 퍼블릭은 1개밖에 안되지만, 클래스는 여러개가 가능하다.
class MySortTest implements Comparator<Score> {

        @Override
        public int compare(Score o1, Score o2) {
            if(o1.getAvg() > o2.getAvg()) {
                return 1;
            } else if (o1.getAvg() < o2.getAvg()) {
                return -1;
            }
            return 0;
        }
    }
    /*
       Comparable
           compareTo(Object other) - 각각의 "나(this)"와 "다른 객체" other을비교

      Comparator
          compare(Object, Object)- 객체1과 객체2를 심판이 비교
     */
