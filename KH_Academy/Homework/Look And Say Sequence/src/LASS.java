import java.util.Arrays;
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

        String[] arr = new String[30];
        int chk_str = 1;
        int count = 0;
        int num = 0;

        Arrays.fill(arr, "0"); // 모든 배열 값 0 으로 초기화

        if (line == 1) {
            arr[0] = "1";
            System.out.println(arr[0]);
        }

        else {
            String[] tmp = lass(line - 1);

            for(int i = 0; !tmp[i].equals("0");  i++) {
                //새로운 문자 체크
                if(!tmp[i].equals(Integer.toString(chk_str))) {
                    if (count > 0) {
                       //체크하던 문자와 찾은 문자 입력
                        arr[num] = Integer.toString(chk_str);
                        arr[num+1] = Integer.toString(count);
                    }
                    //새로운 문자 저장
                    chk_str = Integer.parseInt(tmp[i]);
                    count = 1;
                    num+=2; // 새로운 문자를 저장하기위해 num 값 증가
                }

                else {
                    count++;
                }
            }


            if(count > 0) {
                arr[num] = Integer.toString(chk_str);
                arr[num+1] = Integer.toString(count);
            }

            for (int i = 0; !arr[i].equals("0"); i++) {
                System.out.print(arr[i]);
            }
            System.out.println();

        }

        return arr;
    }
}
