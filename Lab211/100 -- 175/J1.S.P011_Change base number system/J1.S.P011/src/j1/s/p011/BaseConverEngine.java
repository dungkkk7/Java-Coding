package j1.s.p011;

import java.math.BigInteger;

public class BaseConverEngine {

    public String decimalToBinary(String input) {
        BigInteger decimalValue = new BigInteger(input);
        
        if (decimalValue.equals(BigInteger.ZERO)) {
            return "0";
        }
        String output = " "; 
        while (decimalValue.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divmod = decimalValue.divideAndRemainder(BigInteger.valueOf(2));
            output = divmod[1] +output; 
            decimalValue = divmod[0];
        }
        return output;
    }

    public String decimalToHex(String input) {
        BigInteger decimalValue = new BigInteger(input);

        if (decimalValue.equals(BigInteger.ZERO)) {
            return "0";
        }

        String  output = "";
        String hexa = "ABCDEF";
        BigInteger sixteen = BigInteger.valueOf(16);
        while (decimalValue.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divmod = decimalValue.divideAndRemainder(sixteen);
            int sodu = divmod[1].intValue();
            if (sodu >= 10) {
                output =  hexa.charAt(sodu - 10) +output;
            } else {
                output = sodu + output; 
            }
            decimalValue = divmod[0];
        }

        

        return output;
    }

    public String binarytoDecimal(String input) {
       

        BigInteger output = BigInteger.ZERO;
        BigInteger somu = BigInteger.ONE;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == '1') {
                output = output.add(somu);
            }
            somu = somu.multiply(BigInteger.valueOf(2));
        }

        return output.toString();
    }

    public String binarytoHex(String input) {
        input = binarytoDecimal(input);
        return decimalToHex(input);
    }

    public String hexaToBinary(String input) {
        input = hexaToDecimal(input);
        return decimalToBinary(input);
    }

    public String hexaToDecimal(String input) {
       

        BigInteger output = BigInteger.ZERO;
        BigInteger somu = BigInteger.ONE;
        String HexDigit = "0123456789ABCDEF";
        for (int i = input.length() - 1; i >= 0; i--) {
            int index = HexDigit.indexOf(Character.toUpperCase(input.charAt(i)));
            output = output.add(BigInteger.valueOf(index).multiply(somu));
            somu = somu.multiply(BigInteger.valueOf(16));
        }
        return output.toString();
    }

    public void start(int choiceInput, int choiceOutput) {
        String input = "";
        switch (choiceInput) {
            case 1:
                input = InputGetter.getBinary("Enter binary value:");
                break;
            case 2:
                input = InputGetter.getInteger("Enter decimal value:");
                break;
            case 3:
                input = InputGetter.getHexaDecimal("Enter hexa value:");
        }

        System.out.println("This is output:");
        switch (choiceInput) {
            case 1:
                if (choiceOutput == 2) {
                    System.out.println(binarytoDecimal(input));
                }
                if (choiceOutput == 3) {
                    System.out.println(binarytoHex(input));
                }
                break;
            case 2:
                if (choiceOutput == 1) {
                    System.out.println(decimalToBinary(input));
                }
                if (choiceOutput == 3) {
                    System.out.println(decimalToHex(input));
                }
                break;
            case 3:
                if (choiceOutput == 2) {
                    System.out.println(hexaToDecimal(input));
                }
                if (choiceOutput == 1) {
                    System.out.println(hexaToBinary(input));
                }
                break;
        }
    }
}
