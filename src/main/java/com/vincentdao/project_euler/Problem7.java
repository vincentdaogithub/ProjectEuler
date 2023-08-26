package com.vincentdao.project_euler;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {

    private static final long NTH_PRIME = 10001;

    public static void main(String[] args) {
        List<Long> primes = new ArrayList<>();
        primes.add(2L);
        long count = 1;
        long tracker = 3;
        while (count < NTH_PRIME) {
            boolean isPrime = true;
            for (long prime : primes) {
                if (tracker % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(tracker);
                count++;
            }
            tracker++;
        }
        System.out.println(primes.get((int) (NTH_PRIME - 1)));
    }
}
