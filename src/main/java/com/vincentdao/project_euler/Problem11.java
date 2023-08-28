package com.vincentdao.project_euler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11 {

    private static final String INPUT_PATH = "input/problem11.txt";
    private static final int GRID_SIZE = 20;
    private static final int ADJACENT_LENGTH = 4;

    public static void main(String[] args) {
        int[][] input = new int[GRID_SIZE][GRID_SIZE];
        try (InputStream is = ClassLoader.getSystemResourceAsStream(INPUT_PATH)) {
            assert is != null;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line = br.readLine();
                int row = 0;
                while (line != null) {
                    StringTokenizer tk = new StringTokenizer(line, " ");
                    for (int col = 0; col < GRID_SIZE; col++) {
                        input[row][col] = Integer.parseInt(tk.nextToken());
                    }
                    row++;
                    line = br.readLine();
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        int largestProduct = 0;
        int steps = GRID_SIZE - ADJACENT_LENGTH + 1;

        // horizontal check
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int step = 0; step < steps; step++) {
                int product = 1;
                for (int col = 0; col < ADJACENT_LENGTH; col++) {
                    product *= input[row][col + step];
                }
                if (product > largestProduct) {
                    largestProduct = product;
                }
            }
        }

        // vertical check
        for (int col = 0; col < GRID_SIZE; col++) {
            for (int step = 0; step < steps; step++) {
                int product = 1;
                for (int row = 0; row < ADJACENT_LENGTH; row++) {
                    product *= input[row + step][col];
                }
                if (product > largestProduct) {
                    largestProduct = product;
                }
            }
        }

        // downward diagonal check
        for (int row = 0; row < steps; row++) {
            for (int col = 0; col < steps; col++) {
                int product = 1;
                for (int step = 0; step < ADJACENT_LENGTH; step++) {
                    product *= input[row + step][col + step];
                }
                if (product > largestProduct) {
                    largestProduct = product;
                }
            }
        }

        // upward diagonal check
        for (int row = ADJACENT_LENGTH - 1; row < GRID_SIZE; row++) {
            for (int col = 0; col < steps; col++) {
                int product = 1;
                for (int step = 0; step < ADJACENT_LENGTH; step++) {
                    product *= input[row - step][col + step];
                }
                if (product > largestProduct) {
                    largestProduct = product;
                }
            }
        }
        System.out.println(largestProduct);
    }
}
