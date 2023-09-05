package com.vincentdao.project_euler;

/**
 * <a href="https://en.wikipedia.org/wiki/Bunyakovsky_conjecture">Bunyakovsky conjecture</a><br />
 * <a href="https://en.wikipedia.org/wiki/Ulam_spiral#Hardy_and_Littlewood's_Conjecture_F">
 *     Hardy and Littlewood's Conjecture F</a>
 */
public class Problem27 {

    private static final int MAX_A = 1000;
    private static final int MAX_B = 1000;

    public static void main(String[] args) {
        int largestCount = 0;
        int resultA = 0;
        int resultB = 0;
        for (int a = -(MAX_A - 1); a < MAX_A; a++) {
            for (int b = -MAX_B; b <= MAX_B; b++) {
                int largerNum = Math.max(a, b);
                int smallerNum = Math.min(a, b);
                boolean allCoefficientsAreRelativelyPrime = true;
                for (int i = 2; i <= smallerNum; i++) {
                    if (largerNum % i == 0) {
                        allCoefficientsAreRelativelyPrime = false;
                        break;
                    }
                }
                // a and b are not relatively prime => exclude
                // a and b are all even => results are always even => exclude
                if (!allCoefficientsAreRelativelyPrime || ((1 + a) % 2 == 0 && b % 2 == 0)) {
                    continue;
                }

                // now, the formula is n^2 + an + b
                int count = 0;
                for (int n = 0; true; n++) {
                    int pn = n * n + a * n + b;
                    // check for prime
                    boolean isPrime = true;
                    for (int i = 2; i <= Math.sqrt(pn); i++) {
                        if (pn % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (!isPrime) {
                        if (count > largestCount) {
                            resultA = a;
                            resultB = b;
                            largestCount = count;
                        }
                        break;
                    }
                    count++;
                }
            }
        }
        System.out.println(resultA * resultB);
    }
}
