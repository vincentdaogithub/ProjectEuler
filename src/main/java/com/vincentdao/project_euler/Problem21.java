package com.vincentdao.project_euler;

public class Problem21 {

    private static final int MAX = 10000;

    public static void main(String[] args) {
        long amicableSum = 0;
        for (int a = 1; a < MAX; a++) {
            int b = sumOfProperDivisors(a);
            if (b > a && a == sumOfProperDivisors(b)) {
                amicableSum += a;
            }
        }
        System.out.println(amicableSum);
    }

    private static int sumOfProperDivisors(int num) {
        int sum = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
