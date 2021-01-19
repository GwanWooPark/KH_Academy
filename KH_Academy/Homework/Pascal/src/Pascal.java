import java.util.Scanner;

public class Pascal {

    public static void main(String[] args) {

        int line;
        Scanner scanner = new Scanner(System.in);
        System.out.print("라인 입력 : ");
        line = scanner.nextInt();

        Pas(line, line);

        //n번째 라인의 m번째 숫자 = (n-1)번째 라인의 (m-1)번째 숫자 + (n-1)번째 라인의 m번째 숫자
    }


    public static int[] Pas(int line, int blank) {

        int[] idx = new int[line];

        if(line == 1) {
            idx[0] = 1;
            for (int j = blank; j > 0; j--)
                System.out.print(" ");

            for(int i = line; i > 0; i--)
            System.out.println(idx[0]);
            return idx;
        }
        else if (line == 2) {
            idx[0] = 1;
            idx[1] = 1;
            Pas(line-1, blank);

            for (int j = blank-1; j > 0; j-=2){
                System.out.print(" ");
            }
            for(int i = line; i > 0; i--)
                System.out.print(" ");
            System.out.println(idx[0] + " " + idx[1]);
            return idx;
        }

        else {
            int[] temp = Pas(line - 1, blank);
            idx[0] = 1;
            idx[line-1] = 1;
            for(int i = 1; i < line - 1; i++) {
                idx[i] = temp[i-1] + temp[i];
            }

            for(int j = 0; j < line; j++)
                System.out.print(idx[j] + " ");
            System.out.println();
            return idx;
        }

    }
}
