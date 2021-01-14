import jdk.swing.interop.SwingInterOpUtils;

import java.time.Year;
import java.util.Calendar;
import java.util.Locale;

public class UseUtil {
    public static void main(String[] args) {


        Calendar cal = Calendar.getInstance(Locale.KOREA);

        System.out.println("오늘 : " + cal.get(Calendar.YEAR) + "년 " + cal.get(Calendar.MONTH) + 1 + "월 " + cal.get(Calendar.DATE) + "일 "
                + cal.get(Calendar.HOUR_OF_DAY) + "시 " + cal.get(Calendar.MINUTE) + "분 " + cal.get(Calendar.SECOND) + "초");



        for(int i = 0; i < 12; i++) {
            cal.set(Calendar.MONTH, i);
            System.out.printf("\n\t\t%d년 %d월\n", cal.get(Calendar.YEAR), i+1);
            System.out.println("일\t월\t화\t수\t목\t금\t토");

//            int month = cal.get(Calendar.MONTH);
//            System.out.println(month);

            for (int day = 1; day < cal.getActualMaximum(Calendar.DAY_OF_MONTH) + 1; day++)
            {
                cal.set(Calendar.DATE, day);
                int day_of_week = cal.get(Calendar.DAY_OF_WEEK);


                System.out.printf("%d\t", day);
                 if(day_of_week % 7 == 0)
                   System.out.println();
            }

        }

    }
}
