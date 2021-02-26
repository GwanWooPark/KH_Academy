package com.test03;

import com.compare.Score;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MTest02 {

    public static void main(String[] args) {

        Set<Score> set = new HashSet<Score>();
        set.add(new Score("홍길동", 100, 90, 60));
        set.add(new Score("이순신", 50, 95, 100));
        set.add(new Score("김선달", 88, 100, 58));

        //printSet(set);
        transElemnet(set, "이순신", 55);
    }

    private static void transElemnet(Set<Score> set, String name, int kor) {

        // set에서 name을 찾아서, 국어점수의 값을 kor로 바꾸고, 전체 출력하자.
        Iterator<Score> iterator = set.iterator();

        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if (temp.getName().equals(name)) {
                temp.setKor(kor);
            }
        }
        System.out.println(set);

        /* Object[] objectsArr = set.toArray();
        for (int i = 0; i < objectsArr.length; i++) {
            if (((Score)objectsArr[i]).getName().equals(name)) {
                ((Score)objectsArr[i]).setKor(kor);
            }
            System.out.println(objectsArr[i]);
        }*/
    }

    public static void printSet(Set<Score> set) {

        // 방법 1
      /*  for (Score sc : set
        ) {
            System.out.println(sc);
        }*/

        // 방법 2
 /*       Object[] objectsArr = set.toArray();
        for (int i = 0; i < objectsArr.length; i++) {
            // 이름만 출력
            System.out.println(((Score)objectsArr[i]).getName());
        }*/

        // 방법 3
        // Iterator : collection의 저장 요소들을 읽어드리는 표준화된 방법
        Iterator<Score> iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
