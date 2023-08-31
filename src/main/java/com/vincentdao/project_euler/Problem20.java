package com.vincentdao.project_euler;

public class Problem20 {

    private static final int MAX = 100;
    private static final int MAX_SIZE = 100;
    private static final long SECTION_SIZE = 10000000L;

    public static void main(String[] args) {
        long[] result = new long[MAX_SIZE];
        int size = 1;
        result[0] = 2;
        for (int num = 3; num <= MAX; num++) {
            long carryOver = 0;
            for (int i = 0; i < size; i++) {
                long product = result[i] * num + carryOver;
                result[i] = product % SECTION_SIZE;
                carryOver = product / SECTION_SIZE;
                if (carryOver > 0 && i + 1 == size) {
                    size++;
                }
            }
        }
        long digitsSum = 0;
        for (int i = 0; i < size; i++) {
            long num = result[i];
            while (num > 0) {
                digitsSum += num % 10;
                num /= 10;
            }
        }
        System.out.println(digitsSum);
    }
}
