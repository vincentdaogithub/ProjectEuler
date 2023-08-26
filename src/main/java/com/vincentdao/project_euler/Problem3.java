package com.vincentdao.project_euler;

import com.vincentdao.project_euler.common.PrimeTableGenerator;

import java.util.List;

public class Problem3 {

    private static final int PRIME_SIZE = 10000;

    public static void main(String[] args) {
        List<Integer> primes = PrimeTableGenerator.generateWithSieveOfEratosthenes(PRIME_SIZE);
        long givenNum = 600851475143L;
        long result = 0;
        for (Integer i : primes) {
            if (givenNum == 1) {
                System.out.println(result);
                return;
            }
            if (givenNum % i == 0) {
                givenNum /= i;
                result = i;
            }
        }
        System.out.println("Not found");
    }
}
