package com.vincentdao.project_euler;

import com.vincentdao.project_euler.common.PrimeTableGenerator;

import java.util.List;

public class Problem5 {

    private static final long MAX = 20;

    public static void main(String[] args) {
        List<Long> primes = PrimeTableGenerator.generateWithSieveOfEratosthenes(100);
        long result = 2;
        for (long i = 3; i <= MAX; i++) {
            if (result % i != 0) {
                for (long prime : primes) {
                    long tmp = result * prime;
                    if (tmp % i == 0) {
                        result = tmp;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
