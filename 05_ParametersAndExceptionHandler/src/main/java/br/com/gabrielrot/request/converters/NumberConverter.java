package br.com.gabrielrot.request.converters;

import br.com.gabrielrot.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Invalid numeric value");

        return Double.parseDouble(strNumber);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;

        String number = strNumber.replace(",", "."); // BRL R$ 5,00 | USD $5.00

        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }

}
