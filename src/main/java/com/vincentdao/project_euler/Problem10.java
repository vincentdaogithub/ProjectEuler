package com.vincentdao.project_euler;

import com.vincentdao.project_euler.common.PrimeTableGenerator;

public class Problem10 {

    private static final int MAX = 2000000;

    public static void main(String[] args) {
        System.out.println(PrimeTableGenerator
                .generateWithSieveOfEratosthenes(MAX)
                .stream()
                .reduce(0L, Long::sum));
    }
}
