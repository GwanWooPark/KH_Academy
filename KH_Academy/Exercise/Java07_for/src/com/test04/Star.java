package com.test04;

public class Star {


    public static void prn01() {


    }

    public static void prn02() {


    }

    /*
     *
     **
     ***
     ****
     *****

     */
    public static void prn03() {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++) {
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

        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++)
                System.out.print("★");

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


     */
    public static void prn05() {

        int con = 0;

        for (int i = 10; i > 0; i--) {
            int count = (i / 2) + 2;
            if (i % 2 == 1) {
                for (int j = 0; j < con; j++) {

                    for (int k = count; count > 0; count--)
                        System.out.print(" ");

                    System.out.print("★");
                }
                    System.out.println();
            }

            con++;
        }
    }

}
