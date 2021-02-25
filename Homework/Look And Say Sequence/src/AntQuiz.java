import java.util.Scanner;

public class AntQuiz {

    public static void main(String[] args) {

        System.out.println("input stage : ");
        Scanner sc = new Scanner(System.in);
        antPrn(sc.nextInt());

    }

    public static void antPrn(int stage) {

        String start = "1";
        System.out.println(start);

        for (int i = 1; i < stage; i++) {
            start = ant(start);
            System.out.println(start);
        }
    }

    public static String ant(String input) {

        String res = "";

        char index = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (index == input.charAt(i)) {
                count++;
            } else {
                res = res + index + count;
                index = input.charAt(i);
                count = 1;
            }
        }

        res = res + index + count;

        return res;
    }
}
