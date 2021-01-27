import java.util.Scanner;

public class TeacherVersion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Level : ");
        int n = sc.nextInt();

        int[][] arr = new int[n][];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i+1];

            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == arr[i].length-1)
                    arr[i][j] = 1;
                else
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length; j > i; j--)
                System.out.print("  ");

            for (int j = 0; j < arr[i].length; j++)
                System.out.printf("%4d",arr[i][j]);

            System.out.println();
        }
    }
}
