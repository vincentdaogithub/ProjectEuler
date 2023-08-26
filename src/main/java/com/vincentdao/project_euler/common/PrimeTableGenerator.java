package com.vincentdao.project_euler.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class PrimeTableGenerator {

    private static final int MAX_COL = 100000;

    private PrimeTableGenerator() {
    }

    public static List<Long> generateWithSieveOfEratosthenes(long max) {
        int maxRow = (int) (max / MAX_COL + 1);
        boolean[][] primeTable = new boolean[maxRow][MAX_COL];
        List<Long> primes = new LinkedList<>();
        int row = 0;
        int col = 2;
        for (int count = 2; count < max; count++) {
            if (!primeTable[row][col]) {
                primes.add((long) count);
                int tmpCount = count;
                for (int i = 2; 0 < tmpCount && tmpCount < max; i++) {
                    int tmpRow = tmpCount / MAX_COL;
                    int tmpCol = tmpCount % MAX_COL;
                    primeTable[tmpRow][tmpCol] = true;
                    tmpCount = count * i;
                }
            }
            if ((count + 1) % MAX_COL == 0) {
                row++;
                col = 0;
                continue;
            }
            col++;
        }
        return primes;
    }
}
