package com.vincentdao.project_euler;

public class Problem9 {

    private static final long MAX_SUM = 1000;

    public static void main(String[] args) {
        for (long c = 1; c < MAX_SUM / 2; c++) {
            long abSum = 1000 - c;
            long abProduct = 500000 - (1000 * c);
            for (long a = 1; a <= c / 2; a++) {
                if (a * (abSum - a) == abProduct) {
                    System.out.println(abProduct * c);
                    return;
                }
            }
        }
    }
}
