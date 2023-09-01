package com.vincentdao.project_euler;

import com.vincentdao.project_euler.common.LargeInteger;

public class Problem25 {

    private static final int MAX_DIGITS_COUNT = 1000;

    public static void main(String[] args) {

        LargeInteger num1 = new LargeInteger(1);
        LargeInteger num2 = new LargeInteger(1);
        LargeInteger result = new LargeInteger(0);
        long resultIndex = 2;
        while (result.getDigitsCount() < MAX_DIGITS_COUNT) {
            result = num1.add(num2);
            num1 = num2;
            num2 = result;
            resultIndex++;
        }
        System.out.println(resultIndex);
    }
}
