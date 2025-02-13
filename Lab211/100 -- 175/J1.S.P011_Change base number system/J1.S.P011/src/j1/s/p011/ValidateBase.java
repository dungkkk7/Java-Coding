/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p011;

/**
 *
 * @author 84823
 */
public class ValidateBase {

    private static final String BINARY_VALID = "-?[0-1]+";
    private static final String INTEGER_VALID = "-?[0-9]+";
    private static final String HEXADECIMAL_VALID = "-?[0-9A-Fa-f]+";

    public static boolean checkValidateChoice(int choice, int flag) {
        if (flag == 0) {
            return choice == 1 || choice == 2 || choice == 3 || choice == 4;
        } else {
            return choice != flag && (choice == 4 || choice == 2 || choice == 3 || choice == 1);
        }

    }

    public static boolean checkBinary(String input) {
        return input.matches(BINARY_VALID);
    }

    public static boolean checkInteger(String input) {
        return input.matches(INTEGER_VALID);

    }

    public static boolean checkHexaDecimal(String input) {
        return input.matches(HEXADECIMAL_VALID);
    }

}
