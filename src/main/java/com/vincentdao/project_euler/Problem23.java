package com.vincentdao.project_euler;

import com.vincentdao.project_euler.common.DivisorOperations;

public class Problem23 {

    private static final int LIMIT = 28123;

    public static void main(String[] args) {
        boolean[] abundantTable = new boolean[LIMIT + 1];
        for (int num = 12; num <= LIMIT; num++) {
            if (!abundantTable[num] && DivisorOperations.sumOfProperDivisors(num) > num) {
                for (int multiplier = 1; num * multiplier <= LIMIT; multiplier++) {
                    abundantTable[num * multiplier] = true;
                }
            }
        }
        boolean[] abundantSumTable = new boolean[LIMIT + 1];
        for (int firstNum = 1; firstNum <= LIMIT; firstNum++) {
            if (abundantTable[firstNum]) {
                for (int secondNum = 12; firstNum + secondNum <= LIMIT; secondNum++) {
                    if (abundantTable[secondNum]) {
                        abundantSumTable[secondNum + firstNum] = true;
                    }
                }
            }
        }
        long resultSum = 0;
        for (int i = 1; i <= LIMIT; i++) {
            if (!abundantSumTable[i]) {
                resultSum += i;
            }
        }
        System.out.println(resultSum);
    }
}
