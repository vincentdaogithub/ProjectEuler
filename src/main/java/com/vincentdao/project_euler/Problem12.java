package com.vincentdao.project_euler;

import com.vincentdao.project_euler.common.PrimeTableGenerator;

import java.util.List;

public class Problem12 {

    private static final int FACTORS_COUNT = 500;

    public static void main(String[] args) {
        List<Long> primes = PrimeTableGenerator.generateWithSieveOfEratosthenes(10000);
        long resultNum = 1;
        for (long addNum = 2; ; addNum++) {
            int count = 1;
            long prime = primes.get(0);
            for (int i = 1; prime <= Math.sqrt(resultNum); i++) {
                if (resultNum % prime == 0) {
                    int primeCount = 0;
                    long tmp = resultNum;
                    while (tmp > 1) {
                        if (tmp % prime != 0) {
                            break;
                        }
                        primeCount++;
                        tmp /= prime;
                    }
                    count *= (primeCount + 1);
                }
                prime = primes.get(i);
            }
            if (count > FACTORS_COUNT) {
                System.out.println(resultNum);
                return;
            }
            resultNum += addNum;
        }
    }
}
