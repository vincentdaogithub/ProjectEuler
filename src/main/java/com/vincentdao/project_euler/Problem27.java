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
            for (int b = 2; b <= MAX_B; b++) {
                boolean allCoefficientsAreRelativelyPrime = isAllCoefficientsAreRelativelyPrime(a, b);
                // a and b are not relatively prime => exclude
                // a + 1 (in which 1 is the coefficient of the degree of 2) and b are all even
                // => results are always even => exclude? since 2 is prime too
                // ((a + 1) % 2 == 0 && b % 2 == 0)
                if (!allCoefficientsAreRelativelyPrime) {
                    continue;
                }

                // now, the formula is n^2 + an + b
                int count = 0;
                for (int n = 0; true; n++) {
                    int pn = n * n + a * n + b;
                    boolean isPrime = pn >= 2;
                    // check for prime
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
        System.out.println(largestCount);
        System.out.println(resultA * resultB);
    }

    private static boolean isAllCoefficientsAreRelativelyPrime(int a, int b) {
        int largerNum = Math.abs(Math.max(a, b));
        int smallerNum = Math.abs(Math.min(a, b));
        if (smallerNum == 0 || smallerNum == 1) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(smallerNum); i++) {
            if (largerNum % i == 0 && smallerNum % i == 0) {
                return false;
            }
        }
        return largerNum % smallerNum != 0;
    }
}
