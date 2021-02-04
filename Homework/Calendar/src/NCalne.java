import java.util.Scanner;

public class NCalne {
    public static void main(String[] args) {

        int year, month;
        Scanner scanner = new Scanner(System.in);

        String[] day = {"SUN", "MON", "TUE" , "WEN", "THU", "FRI", "SAT"};

        System.out.print("연도를 입력하세요 : ");
        year = scanner.nextInt();

        System.out.print("월을 입력하세요 : ");
        month = scanner.nextInt();

        System.out.println(year + "년 " + month + "월");

        int[] last_day = {31, 28, 31, 30, 31, 30 ,31 ,31 ,30, 31, 30, 31};

        //① 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고,
        // ② 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며,
        // ③ 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다.

        int all_day = (year -1)*365 + (year - 1)/4  - (year-1)/100 + (year-1)/400;

        if((year%4 == 0 && year%100 != 0) || year%400 == 0)  //윤달 계산법
            last_day[1] = 29;

        for(int i = 0; i < month - 1; i++){
            all_day += last_day[i];
        }

        all_day +=1;
        int week = all_day % 7; //첫 일 구하기
        
        for(int i = 0; i < day.length; i++) {
            System.out.print(day[i] + "\t");
        }
        
        System.out.println();

        //첫 일의 시작 요일에 맞춤
        for (int j = 0; j < week; j++)
            System.out.print("\t ");

        for(int i = 1; i <= last_day[month-1]; i++) {
            System.out.print(i + "\t ");
            week++;
            if(week % 7 == 0) // 매주 끝마다 줄바꿈
                System.out.println();
        }

    }
}
