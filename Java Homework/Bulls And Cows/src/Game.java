import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        strat();
    }

    public static int[] setCom_num() {

        int[] com_num = new int[3];
        for (int i = 0; i < com_num.length; i++) {
            com_num[i] = (int) (Math.random() * 8 + 1);
            for (int j = 0; j < i; j++) {
                if (com_num[i] == com_num[j]) {
                    i--;
                    break;
                }
            }
        }
        return com_num;
    }

    public static int[] setMy_num() {

        int[] my_num = new int[3];
        Scanner sc = new Scanner(System.in);
        System.out.println("1~9사이의 중복되지 않은 숫자 3개를 입력하십시오.");

        /*try {
            for (int i = 0; i < my_num.length; i++) {
                my_num[i] = sc.nextInt();
            }
        }catch (Exception e) {
            System.out.println("1~9사이의 값이 아니거나 중복된 값이 들어왔습니다.");
            setMy_num();
        }finally {
            System.out.print("내가 입력한 숫자 : ");
            for (int i = 0; i < 3; i++)
                System.out.print(my_num[i] + " ");
        }*/


        for (int i = 0; i < my_num.length; i++) {
            my_num[i] = sc.nextInt();

            if(my_num[i] > 9 || my_num[i] < 1) {
                i--;
                System.out.println("1 ~ 9사이의 값만 입력해주세요");
            }

            for (int j = 0; j < i; j++) {
                if (my_num[i] == my_num[j]) {
                    i--;
                    System.out.print("중복! 다시 입력하십시오 : ");
                }
            }
        }
        return my_num;
    }

    public static void strat() {

        int count = 0;
        int count_s = 0;
        int count_b = 0;

        int[] com_num = setCom_num();

        while (true) {

            int[] my_num = setMy_num();
            if (count == 10) {
                System.out.print("컴퓨터의 숫자는 : ");
                for (int i = 0; i < com_num.length; i++) {
                    System.out.print(com_num[i] + " ");

                }
                System.out.print("당신의 패배입니다!");
                break;
            }

            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {
                    if (com_num[i] == my_num[j] && i == j)
                        count_s++;
                    else if (com_num[i] == my_num[j] && i != j)
                        count_b++;
                }
            }
            
            System.out.println();

            if (count_s == 3 && count_b == 0) {
                count++;
                System.out.println("정답!");
                System.out.printf("시도횟수는 %d번 입니다!", count);
                break;

            } else if (count_s != 0 || count_b != 0) {
                System.out.printf("%dStrike %dBall! \n", count_s, count_b);
                count_s = 0;
                count_b = 0;
                count++;

            } else {
                System.out.println("아웃!");
                count++;
            }
        }

    }
}
