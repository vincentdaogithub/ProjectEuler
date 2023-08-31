package com.vincentdao.project_euler;

import com.vincentdao.project_euler.common.InputFileReader;
import com.vincentdao.project_euler.common.Print2DArray;

import java.util.List;
import java.util.StringTokenizer;

public class Problem18 {

    private static final String PATH = "input/problem18.txt";
    public static void main(String[] args) {
        List<String> input = InputFileReader.readFileIntoListOfString(PATH);
        int size = input.size();;
        int[][] inputs = new int[size][size];
        for (int row = 0; row < size; row++) {
            StringTokenizer tk = new StringTokenizer(input.get(row), " ");
            for (int col = 0; tk.hasMoreTokens(); col++) {
                inputs[row][col] = Integer.parseInt(tk.nextToken());
            }
        }
        int[][] dijkstraTable = new int[size][size];
        dijkstraTable[0][0] = inputs[0][0];

        for (int row = 0; row < size - 1; row++) {
            for (int node = 0; node <= row; node++) {
                for (int col = 0; col < 2; col++) {
                    int sum = dijkstraTable[row][node] + inputs[row + 1][node + col];
                    if (sum > dijkstraTable[row + 1][node + col]) {
                        dijkstraTable[row + 1][node + col] = sum;
                    }
                }
            }
        }
        Print2DArray.printIntArray(dijkstraTable, size, size);
        long maxSum = 0;
        for (int col = 0; col < size; col++) {
            if (dijkstraTable[size - 1][col] > maxSum) {
                maxSum = dijkstraTable[size - 1][col];
            }
        }
        System.out.println(maxSum);
    }
}
