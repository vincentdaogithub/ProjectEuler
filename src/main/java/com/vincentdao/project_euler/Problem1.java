package com.vincentdao.project_euler;

public class Problem1 {

    public static void main(String[] args) {
        long resultSum = 0;
        for (long i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                resultSum += i;
            }
        }
        System.out.println(resultSum);
    }
}
