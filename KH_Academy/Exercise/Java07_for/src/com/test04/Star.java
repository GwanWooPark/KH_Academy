package com.test04;

public class Star {
    /*
        *
        **
        ***
        ****
        *****
     */
    public static void prn01() {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("★");
            }
            System.out.println();
        }
        System.out.println("--------------------");

    }

    public static void prn02() {
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++)
                System.out.print("★");

            System.out.println();
        }
        System.out.println("--------------------");

    }

    /*
           *
          **
         ***
       *****
      ******

     */

    public static void prn03() {

        for (int i = 0; i < 5; i++)
        {
            for(int k = 0; k < 5 - i; k++) {
                System.out.print("☆");
            }

            for (int j = 0; j < i+1; j++){
                System.out.print("★");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    /*
     *****
      ****
       ***
        **
         *
     */

    public static void prn04() {

        for (int i = 5; i > 0 ; i--) {
            for (int k = 0; k < 5 - i; k++) {
                System.out.print("☆");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("★");
            }
            System.out.println();

        }
        System.out.println("--------------------");
    }

    /*
         *
        ***
       *****
      *******
     *********
     *
     */

    public static void prn05() {

        int con = 0;

        for (int i = 10; i > 0; i--) {
            int count = (i / 2);
            if (i % 2 == 1) {
                for (int j = 0; j < con; j++) {

                    for (int k = count; count > 0; count--)
                        System.out.print("☆");

                    System.out.print("★");
                }
                    System.out.println();
            }
            con++;
        }
        System.out.println("--------------------");
        for (int i = 0; i < 5; i++) {
            for (int j = 4 - i; j > 0; j--) {
                System.out.print("☆");
            }
            // K는 별 (2*0 + 1, 2*1 + 1, ...)
            for (int k = 0; k < 2*i + 1; k++) {
                System.out.print("★");
            }
            System.out.println();
        }
    }

}
