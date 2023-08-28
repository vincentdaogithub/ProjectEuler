package com.vincentdao.project_euler;

import com.vincentdao.project_euler.common.InputFileReader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Problem13 {

    private static final String INPUT_PATH = "input/problem13.txt";
    private static final int FIRST_DIGITS_LENGTH = 10;

    public static void main(String[] args) {
        List<String> input = InputFileReader.readFileIntoListOfString(INPUT_PATH);
        solveUsingBigDecimal(input);
        solveNormally(input);
    }

    public static void solveUsingBigDecimal(List<String> input) {
        BigDecimal result = BigDecimal.ZERO;
        for (String num : input) {
            result = result.add(new BigDecimal(num));
        }
        System.out.println(result.toString().substring(0, FIRST_DIGITS_LENGTH));
    }

    public static void solveNormally(List<String> input) {
        List<Integer> result = new ArrayList<>(50);
        String firstNum = input.get(0);
        for (int i = firstNum.length() - 1; i >= 0; i--) {
            result.add(firstNum.charAt(i) - '0');
        }
        List<String> tmpInput = new ArrayList<>(input);
        tmpInput.remove(0);
        for (String numString : tmpInput) {
            boolean hasCarryOver = false;
            for (int numIndex = numString.length() - 1, resultIndex = 0; numIndex >= 0; numIndex--, resultIndex++) {
                int sum = result.get(resultIndex) + (numString.charAt(numIndex) - '0') + (hasCarryOver ? 1 : 0);
                if (sum >= 10) {
                    result.set(resultIndex, sum % 10);
                    hasCarryOver = true;
                } else {
                    result.set(resultIndex, sum);
                    hasCarryOver = false;
                }
            }
            for (int carryOverIndex = numString.length(); hasCarryOver; carryOverIndex++) {
                if (carryOverIndex == result.size()) {
                    result.add(1);
                    break;
                }
                int digit = result.get(carryOverIndex) + 1;
                if (digit >= 10) {
                    result.set(carryOverIndex, digit % 10);
                } else {
                    result.set(carryOverIndex, digit);
                    hasCarryOver = false;
                }
            }
        }
        for (int i = result.size() - 1; i >= result.size() - FIRST_DIGITS_LENGTH; i--) {
            System.out.print(result.get(i));
        }
        System.out.println();
    }
}
