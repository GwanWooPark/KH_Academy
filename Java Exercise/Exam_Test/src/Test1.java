import java.util.Scanner;

public class Test1 {
/*
     고객 요구사항

 1. 가위 바위 보 중 하나의 문자열을 입력 받고, 난수를 발생시켜 랜덤하게 가위 바위 보 문자열을 생성한다.
 2. 랜덤한 가위 바위 보 문자열과 입력한 문자열이 같으면 아래 실행 결과처럼 비겼다고 출력하고 가위 바위 보 게임을 반복한다.
 3 입력한 가위 바위 보 문자열이 랜덤한 가위 바위 보 문자열과 비교하여 가위 바위 보 게임의 룰 대로 이긴 경우 이겼다고 출력, 진 경우 졌다고 출력 후 종료

 정상 실행 결과 예시

----------- 컴퓨터에게 지는 경우 -------------

 가위 바위 보 게임을 시작합니다.
 가위 바위 보 중 한 개를 입력하세요 : 가위
 당신은 가위를 냈습니다.
 컴퓨터는 바위를 냈습니다.
 당신이 졌습니다!

-----------컴퓨터에게 이기는 경우 --------------

 가위 바위 보 게임을 시작합니다.
 가위 바위 보 중 한 개를 입력하세요 : 보
 당신은 보를 냈습니다.
 컴퓨터는 바위를 냈습니다.
 당신이 이겼습니다!

-------- 컴퓨터와 비기는 경우 ------------

 가위 바위 보 게임을 시작합니다.
 가위 바위 보 중 한 개를 입력하세요 : 가위
 당신은 가위를 냈습니다.
 컴퓨터는 가위를 냈습니다.
 비겼습니다. 다시 시작합니다.
 가위 바위 보 중 한 개를 입력하세요 : <-- 출력하며 반복됨

 */
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("가위 바위 보 게임을 시작합니다.");

            do {
                System.out.println("가위 바위 보 중 한개를 입력하세요.");
                String input = sc.nextLine();

                System.out.println("당신은" + input + "을 냈습니다");

                int random = (int) (Math.random() * 3);
                String computer = "";

                switch (random) {
                    case 0 : computer = "가위"; break;
                    case 1 : computer = "바위"; break;
                    case 2 : computer = "보" ; break;
                }

                System.out.println("컴퓨터는 " + computer + "를 냈습니다.");

                if (computer.equals(input)) {
                    System.out.println("비겼습니다. 다시 시작합니다");
                } else {
                    boolean win = false;

                    if (computer.equals("가위")) {
                        if (input.equals("바위")){
                            win = true;
                        }
                    } else if (computer.equals("바위")) {
                        if (input.equals("보")) {
                            win = true;
                        }
                    } else {
                        if (input.equals("가위")) {
                            win = true;
                        }
                    }
                    if (win) {
                        System.out.println("당신이 이겼습니다.");
                        break;
                    } else {
                        System.out.println("당신이 졌습니다.");
                        break;
                    }
                }
            }while (true);

        }
}
/* 1. 범위가 하나 틀렸다
2. 무한루프가 되지 않는다. (false -> true)
3. .equlas 메소드가 아니라서 주소 값을 비교하기 때문에 win 값이 바뀌지 않는다.
 */
