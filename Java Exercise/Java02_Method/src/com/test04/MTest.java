package com.test04;

public class MTest {

    // 1. int형 argument 3개를 전달하면, 해당 값들을 모두 더해서 리턴하는 getSum 이라는 이름의 메소드 어디서든 접근 가능하며, static 영역에 만들어진다

    // 2. int형 argument 1개를 전달하면, 해당 값을 3으로 나눠 실수형 결과 값을 리턴하는 getAvg라는 이름의 메소드를 만들자.

    // 3. main 메소드에서 위의 두 메소드를 호출하여, 총점과 평균을 출력하자.


    public static int getSum(int i, int j, int k) {
        int result = i + j + k;
        return result;
    }

    static double getAvg(double sum) {
        double result = sum/3;
        return result;
    }


    public static void main(String[] args) {

        int kor = 100;
        int eng = 40;
        int math = 79;

        int sum = getSum(kor, eng, math);
        double avg = getAvg(sum);

        System.out.printf("총점 : %d 평균 %.1f ", sum, avg);
    }
}
