package com.vincentdao.project_euler;

public class Problem6 {

    private static final long MAX = 100;

    public static void main(String[] args) {
        long resultSum = 0;
        for (long i = 1; i <= MAX; i++) {
            for (long j = 1; j <= MAX; j++) {
                if (i == j) {
                    continue;
                }
                resultSum += i * j;
            }
        }
        System.out.println(resultSum);
    }
}
