package org.example;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static String fizzBuzzCalculation(int n) {
        // 0 is
        if (n == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        String numStr = String.valueOf(Math.abs(n));

//                if(numStr.contains("0")) result.append("");

        // check specific numbers, including negative
        if (numStr.contains("3")) result.append("fizz ");
        if (numStr.contains("5")) result.append("buzz ");
//
//                if (numStr.contains("-3")) result.append("fizz ");
//                if (numStr.contains("-5")) result.append("buzz ");

        // check if number can be multiplied depending on remainder
        if (n % 3 == 0) result.append("fizz ");
        if (n % 5 == 0) result.append("buzz ");


        // return result if anything was appended into it, if not, return the number (String)
        return result.length() > 0 ? result.toString().trim() : numStr;
    }

    public static void main(String[] args) {
//                for (int i = 1; i <= 100; i++) {
//                        System.out.println(i + ": " + fizzBuzzCalculation(i));
//                }
        IntStream.rangeClosed(0, 100)
                .forEach(n -> System.out.println(n + ": " + fizzBuzzCalculation(n)));
    }
}



