import java.util.Scanner;

public class Pascal {

    final int fixed_num = 1;


    public static void main(String[] args) {
        int line;
        Scanner scanner = new Scanner(System.in);
        System.out.print("라인 입력 : ");
        line = scanner.nextInt();


        if (line == 1) {
            System.out.println("1");
        } else if (line == 2) {
            System.out.println(" " + 1);
            System.out.println(" " + 1 + " " + 1);
        } else {
            int[] idx1 = new int[line - 1];
            int[] idx2 = new int[line];
            idx1[0] = 1;
            idx1[1] = 1;

            for (int j = 0; j < line; j++) {
                idx2[j] = 0;
                if (j == 0 || j == line - 1)
                    idx2[j] = 1;
            }
            for (int k = 1; k < line - 1; k++) {
                idx2[k] = idx1[k-1] + idx1[k];
            }
        }
        //n번째 라인의 m번째 숫자 = (n-1)번째 라인의 (m-1)번째 숫자 + (n-1)번째 라인의 m번째 숫자
    }
}
