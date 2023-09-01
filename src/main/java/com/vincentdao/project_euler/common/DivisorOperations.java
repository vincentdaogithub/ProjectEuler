package com.vincentdao.project_euler.common;

public class DivisorOperations {

    private DivisorOperations() {
    }

    public static long sumOfProperDivisors(long num) {
        long sum = 1;
        for (long i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
