package main;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String NUM_REGEX = "^[0-9]*$";

    public Double calculate() {
        String[] values = getInputValues();

        return getResult(values);
    }

    private String[] getInputValues() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.split(" ");
    }

    private Double getResult(String[] values) {
        Double temp1 = null;
        Double temp2 = null;
        String oper = null;

        double result = 0.0;

        for (int i = 0; i < values.length; i ++) {
            String value = values[i];

            if (temp1 != null && temp2 != null && oper != null) {
                result = arithmeticOperation(temp1, temp2, oper);

                temp1 = result;
                temp2 = null;
                oper = null;
            }

            if (Pattern.matches(NUM_REGEX, value)) {
                if (temp1 == null) {
                    temp1 = Double.parseDouble(value);
                    continue;
                }

                temp2 = Double.parseDouble(value);

                if (i == values.length - 1) result = arithmeticOperation(temp1, temp2, oper);
                continue;
            }

            oper = value;
        }

        return result;
    }

    private Double arithmeticOperation(Double a, Double b, String c) {
        if (c.equals("+")) {
            return a + b;
        }

        if (c.equals("-")) {
            return a - b;
        }

        if (c.equals("/")) {
            return a / b;
        }

        return a * b;
    }
}
