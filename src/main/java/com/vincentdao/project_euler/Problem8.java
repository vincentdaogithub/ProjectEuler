package com.vincentdao.project_euler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem8 {

    private static final String INPUT_PATH = "input/problem8.txt";
    private static final long ADJACENT_DIGITS_LENGTH = 13;

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try (InputStream is = ClassLoader.getSystemResourceAsStream(INPUT_PATH)) {
            assert is != null;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                br.lines().forEach(builder::append);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
        String input = builder.toString();
        long result = 0;
        for (long i = 0; i + ADJACENT_DIGITS_LENGTH <= input.length(); i++) {
            String digits = input.substring((int) i, (int) (i + ADJACENT_DIGITS_LENGTH));
            long product = 1;
            for (long j = 0; j < digits.length(); j++) {
                product *= digits.charAt((int) j) - '0';
            }
            if (product > result) {
                result = product;
            }
        }
        System.out.println(result);
    }
}
