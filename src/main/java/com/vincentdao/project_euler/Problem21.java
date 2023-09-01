package com.vincentdao.project_euler;

import com.vincentdao.project_euler.common.DivisorOperations;

public class Problem21 {

    private static final int MAX = 10000;

    public static void main(String[] args) {
        long amicableSum = 0;
        for (int a = 1; a < MAX; a++) {
            int b = (int) DivisorOperations.sumOfProperDivisors(a);
            if (b > a && a == DivisorOperations.sumOfProperDivisors(b)) {
                amicableSum += a;
            }
        }
        System.out.println(amicableSum);
    }
}
