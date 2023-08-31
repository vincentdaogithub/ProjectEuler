package com.vincentdao.project_euler.common;

public class Print2DArray {

    private Print2DArray() {
    }

    public static void printIntArray(int[][] array, int rowSize, int colSize) {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
    }
}
