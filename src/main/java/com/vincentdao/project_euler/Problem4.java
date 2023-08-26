package com.vincentdao.project_euler;

public class Problem4 {

    private static final long MAX = 999L * 999L;

    public static void main(String[] args) {
        for (long num = MAX; num > MAX / 2; num--) {
            String numAsString = Long.toString(num);
            boolean isPalindrome = true;
            int numLength = numAsString.length();
            for (int j = 0; j < numLength; j++) {
                if (numAsString.charAt(j) != numAsString.charAt(numLength - 1 - j)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (!isPalindrome) {
                continue;
            }
            for (long firstProduct = 999; firstProduct >= 100; firstProduct--) {
                if (num % firstProduct == 0) {
                    long secondProduct = num / firstProduct;
                    if (secondProduct >= 100 && secondProduct <= 999) {
                        System.out.println(num);
                        return;
                    }
                }
            }
        }
    }
}
