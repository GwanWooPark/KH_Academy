import java.util.Calendar;
import java.util.Locale;

public class test2 {
    public static void main(String[] args) {


        java.util.Calendar cal = java.util.Calendar.getInstance(Locale.KOREA); //한국 현재 시각 설정

        System.out.println("오늘 : " + cal.get(java.util.Calendar.YEAR) + "년 " + cal.get(java.util.Calendar.MONTH) + 1 + "월 " + cal.get(java.util.Calendar.DATE) + "일 "
                + cal.get(java.util.Calendar.HOUR_OF_DAY) + "시 " + cal.get(java.util.Calendar.MINUTE) + "분 " + cal.get(java.util.Calendar.SECOND) + "초");


        for (int i = 0; i < 12; i++) {

            System.out.printf("\n\t\t%d년 %d월\n", cal.get(java.util.Calendar.YEAR), i + 1);
            System.out.println("일\t월\t화\t수\t목\t금\t토");

            for (int day = 1; day < cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH) + 1; day++) {
                cal.set(java.util.Calendar.MONTH, i);             // 월 설정
                cal.set(java.util.Calendar.DATE, day);            // 일 설정
                int day_of_week = cal.get(java.util.Calendar.DAY_OF_WEEK); // 설정한 x월 x일을 대상으로 요일 반환 (일 = 1, 월 = 2 ...)


                if(day == 1 && day_of_week == 2) // 첫 월의 첫 일을 정확한 요일에 맞추기 위함.
                    System.out.print("\t");
                else if(day == 1 && day_of_week == 3)
                    System.out.print("\t\t");
                else if(day == 1 && day_of_week == 4)
                    System.out.print("\t\t\t");
                else if(day == 1 && day_of_week == 5)
                    System.out.print("\t\t\t\t");
                else if(day == 1 && day_of_week == 6)
                    System.out.print("\t\t\t\t\t");



                System.out.printf("%d\t", day);
                if (day_of_week % 7 == 0) // 토요일 다음 줄 바꿈
                    System.out.println();

            }

        }
    }
}
