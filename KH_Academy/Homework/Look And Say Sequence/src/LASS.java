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

        String[] str = new String[line + 1];

        for(int k = 0; k < line + 1; k++){
            str[k] = "0";
        }

        int count = 0;
        int breakn = 0;
        int num = 0;

        if (line == 1) {
            str[0] = "1";
            System.out.println(str[0]);
            return str;
        }
        else {

            String[] temp = lass(line-1);

            for (int i = 0; i < line; i++) {
                for (int j = breakn; j < line - 1; j++) {
                    if (temp[j].equals(temp[i])) {
                        if (!temp[j].equals(temp[i]))
                            break;
                        else {
                            count++;
                            breakn++;
                        }
                    }

                }
                str[num] = temp[breakn-1];
                num++;
                str[num] = Integer.toString(count);
                count = 0;
            }

        }
        for(int j = 0; j<line; j++) {
            if(str[j].equals("0"))
                break;
            else
                System.out.print(str[j]);
        }
        System.out.println();
        return str;
    }

}

