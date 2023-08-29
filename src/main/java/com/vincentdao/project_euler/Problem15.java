package com.vincentdao.project_euler;

/**
 * Uses Pascal's triangle as solution
 */
public class Problem15 {

    private static final int SIZE = 20;

    public static void main(String[] args) {
        long[][] pascalTriangle = new long[SIZE + 1][SIZE + 1];
        pascalTriangle[0][0] = 1;
        for (int i = 1; i <= SIZE; i++) {
            pascalTriangle[0][i] = 1;
            pascalTriangle[i][0] = 1;
        }
        for (int row = 1; row <= SIZE; row++) {
            for (int col = 1; col <= SIZE; col++) {
                pascalTriangle[row][col] = pascalTriangle[row][col - 1] + pascalTriangle[row - 1][col];
            }
        }
        System.out.println(pascalTriangle[SIZE][SIZE]);
    }
}
