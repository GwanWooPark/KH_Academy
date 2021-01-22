import java.util.Scanner;

public class ch {
    public static void main(String[] args) {

        int [] arr = new int[30];
        int check_int = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
        }

        for (int j = 0; arr[j] != 0; j++) {
            // 새로운 문자가 나왔는지 체크하기
            if(check_int != arr[j]) {
                if (count > 0) {
                    //체크하던 문자와 찾은 횟수 출력
                    System.out.printf("%d%d", check_int, count);
                }
                // 새로운 문자를 저장
                check_int = arr[j];
                // 이미 한 개가 나왔으니 1로 시작
                count = 1;
            }
            else {
                // 같은문자 횟수 증가
                count++;
            }
        }

        if(count > 0) {
            //체크하던 문자와 같은 횟수 출력
            System.out.printf("%d%d", check_int, count);
        }
    }
}

