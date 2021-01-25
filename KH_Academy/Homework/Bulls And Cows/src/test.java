import jdk.swing.interop.SwingInterOpUtils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("연도 입력 : ");
        int year = sc.nextInt();
        System.out.println("월 입력 : ");
        int month = sc.nextInt();

        prn(year, month);
    }

    public static void prn(int year, int month) {
        Calendar cal = Calendar.getInstance();  //싱글턴 패턴, 하나의 인스턴스만 가지고 공유해서 쓴다.
                                                //한번만 객체를 생성하고 그 후에 모든 클래스들이 동일한 객체를 사용하는 방법

        //몇개의 인스턴스를 호출하든 같은 곳을 참조하고있음


        System.out.printf("\t\t%d년 %d월\n", year, month);
        System.out.print("일\t월\t화\t수\t목\t금\t토\n");


        cal.set(year, month-1, 1); // month - 1은 배열의 index와 관련이 있음
        int start = cal.get(Calendar.DAY_OF_WEEK); // 시작날짜 셋팅, DAY_OF_WEEK은 1~7임
        // 일(1), 월(2), 화(3), 수(4) ....


        for (int i = 1; i < start; i++)
            System.out.print("\t");

        for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
            System.out.printf("%d\t", i);
            if(start % 7 == 0) {
                System.out.println();
            }
            start++;
        }
    }
}
