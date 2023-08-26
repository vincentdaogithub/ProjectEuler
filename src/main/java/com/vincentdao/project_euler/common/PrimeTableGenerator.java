package com.vincentdao.project_euler.common;

import java.util.ArrayList;
import java.util.List;

public final class PrimeTableGenerator {

    private PrimeTableGenerator() {
    }

    public static List<Integer> generateWithSieveOfEratosthenes(int size) {
        boolean[] primeTable = new boolean[size];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < size; i++) {
            if (!primeTable[i]) {
                primes.add(i);
            }
            primeTable[i] = true;
            int tracker = i;
            while (true) {
                tracker *= i;
                if (tracker >= size) {
                    break;
                }
                primeTable[tracker] = true;
            }
        }
        return primes;
    }
}
