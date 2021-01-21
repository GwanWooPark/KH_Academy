import java.util.Scanner;

public class LASS {
    /*
       1		-- 1
       11		-- 1이 한개
       12		-- 1이 두개
       1121		-- 1이 한개 2가 한개
       122111		-- 1이 두개 2가 한개 1이 한개
       112213		-- 1이 한개 2가 두개 1이 세개
       12221131		-- 1이 두개 2가 두개 1이 한개 3이 한개

     */


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int line;

        System.out.print("라인 입력 : ");
        line = scanner.nextInt();

        lass(line);


    }

    public static String[] lass(int line) {

    }

}

