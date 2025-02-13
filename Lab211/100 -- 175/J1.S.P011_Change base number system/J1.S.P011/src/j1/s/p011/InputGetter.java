package j1.s.p011;

import java.util.Scanner;

public class InputGetter {

    private static final Scanner sc = new Scanner(System.in);

    public static int getChoice(String mess, int flag) {
        while (true) {
            System.out.print(mess);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                if (ValidateBase.checkValidateChoice(value, flag)) {
                    return value;
                } else {
                    System.out.println("The base of output is invalid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static String getBinary(String mess) {
        while (true) {
            System.out.print(mess);
            try {
                String value = sc.nextLine().trim();
                if (value.isEmpty()) {
                    throw new NullPointerException("Input cannot be empty.");
                }
                // 1010101001010100

                if (ValidateBase.checkBinary(value) ) {
                    return value;
                } 
            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static String getInteger(String mess) {
        while (true) {
            System.out.print(mess);
            try {
                String value = sc.nextLine().trim();
                if (value.isEmpty()) {
                    throw new NullPointerException("Input cannot be empty.");
                }
                // 2147483647
                
                if (ValidateBase.checkInteger(value) ) {
                    return value;
                } 
            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static String getHexaDecimal(String mess) {
        while (true) {
            System.out.print(mess);
            try {
                String value = sc.nextLine().trim();
                if (value.isEmpty()) {
                    throw new NullPointerException("Input cannot be empty.");
                }
                if (ValidateBase.checkHexaDecimal(value) ) {
                    return value;            
                }
            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

//      igInteger number = new BigInteger(value, 2); // 34149348434939
//
//                if (ValidateBase.checkBinary(value) && number.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
//                    return value;
//                } else {
//                    throw new IllegalArgumentException("Binary value exceeds the limit.");
//                }