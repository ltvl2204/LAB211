/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0011;

/**
 *
 * @author Viet Long
 */
public class JSP0011 {
    public static final char[] hexDigits = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    
    //display menu
    public static int menu()
    {
        System.out.println("_ _ _ _ _ _MENU_ _ _ _ _ _");
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexa.");
        System.out.println("4. Exit");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputIntLimit(1, 4);
        return choice;
    }

    //display choose conver
    public static int displayConvert(String from, String toCase1, String toCase2) 
    {
        System.out.println("1. Convert form " + from + " to " + toCase1);
        System.out.println("2. Convert form " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
        int result = Validate.checkInputIntLimit(1, 2);
        return result;
    }

    //allow user convert from binary
    public static void convertFromBinary(String binary) 
    {
        int choice = displayConvert("binary", "decimal", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Decimal: "
                        + convertBinaryToDecimal(binary)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + convertBinaryToHexa(binary));
                break;
        }
    }

    //allow user convert from decimal
    public static void convertFromDecimal(String decimal) 
    {
        int choice = displayConvert("decimal", "binary", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + convertDecimalToBinary(decimal)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + convertDecimalToHexa(decimal));
                break;
        }
    }

    //allow user convert from hexadecimal
    public static void convertFromHexa(String hexa) 
    {
        int choice = displayConvert("hexa", "binary", "decimal");
        switch (choice) 
        {
            case 1:
                System.out.println("Binary: "
                        + convertHexaToBinary(hexa)
                );
                break;
            case 2:
                System.out.println("Decimal: "
                        + convertHexaToDecimal(hexa));
                break;
        }
    }

    //allow user convert from binary to decimal
    public static String convertBinaryToDecimal(String binary) 
    {
        int decimal = Integer.parseInt(binary, 2);
        return Integer.toString(decimal);
    }

    //allow user convert from binary to hexadecimal
    public static String convertBinaryToHexa(String binary) 
    {
        String decimal = convertBinaryToDecimal(binary);
        String hexa = convertDecimalToHexa(decimal);
        return hexa;
    }

    //allow user convert from hexa to decimal
    public static int convertHexaToDecimal(String hexadecimal) 
    {
        int decimal = Integer.parseInt(hexadecimal, 16);
        return decimal;
    }

    //allow user convert from hexadecimal to binary
    public static String convertHexaToBinary(String hexadecimal) 
    {
        String binary = Integer.toBinaryString(convertHexaToDecimal(hexadecimal));
        return binary;
    }

    //allow user convert from decimal to binary
    public static String convertDecimalToBinary(String decimal) 
    {
        String binary = Integer.toBinaryString(Integer.parseInt(decimal));
        return binary;
    }

    //allow user convert from decimal to hexadecimal
    public static String convertDecimalToHexa(String decimal) 
    {
        String hexa = "";
        int deci = Integer.parseInt(decimal);
        while (deci != 0) {
            hexa = hexDigits[deci % 16] + hexa;
            deci /= 16;
        }
        return hexa;
    }

    public static void main(String[] args) 
    {
        //loop until user want to exit
        while (true) 
        {
            int choice = JSP0011.menu();
            switch (choice) 
            {
                case 1:
                    String binary = Validate.checkInputBinary();
                    JSP0011.convertFromBinary(binary);
                    break;
                case 2:
                    String decimal = Validate.checkInputDecimal();
                    JSP0011.convertFromDecimal(decimal);
                    break;
                case 3:
                    String hexa = Validate.checkInputHexaDecimal();
                    JSP0011.convertFromHexa(hexa);
                    break;
                case 4:
                    return;
            }
        }
    }
}