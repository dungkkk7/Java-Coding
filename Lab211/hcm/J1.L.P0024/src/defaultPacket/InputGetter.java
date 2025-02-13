package defaultPacket;

import java.util.Scanner;

public class InputGetter {

    private static final Scanner sc = new Scanner(System.in);

    // các hàm nhập xuát kh có gì 
    public static int getInt(String msg) {
        int value;
        while (true) {
            System.out.println(msg);
            try {
                value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("please enter a number");
            }
        }
    }

    public static String getString(String msg) {
        String value;
        while (true) {
            System.out.println(msg);
            try {
                value = sc.nextLine();
                return value;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static double getDouble(String msg) {
        double value;
        while (true) {
            System.out.println(msg);
            try {
                value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("please enter a number");
            }
        }
    }
}
