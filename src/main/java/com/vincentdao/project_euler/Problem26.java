package com.vincentdao.project_euler;

/**
 * <a href="https://stackoverflow.com/questions/249372/how-to-calculate-recurring-digits">Insight in how this works</a>
 */
public class Problem26 {

    private static final int MAX_DENOMINATOR = 1000;
    private static final int MAX_REMAINDERS_SIZE = 1000;

    public static void main(String[] args) {
        int result = 0;
        int largestCycle = 0;
        for (int denominator = 2; denominator < MAX_DENOMINATOR; denominator++) {
            int[] remainders = new int[MAX_REMAINDERS_SIZE];
            int remaindersSize = 0;
            int remainder = 10;
            while (remainder > 0 && remaindersSize < MAX_REMAINDERS_SIZE) {
                int cycleStart = -1;
                for (int i = 0; i < remaindersSize; i++) {
                    if (remainders[i] == remainder) {
                        cycleStart = i;
                        break;
                    }
                }
                if (cycleStart >= 0) {
                    int count = 0;
                    for (int i = cycleStart; i < remaindersSize; i++) {
                        count++;
                    }
                    if (count > largestCycle) {
                        largestCycle = count;
                        result = denominator;
                    }
                    break;
                }
                remainders[remaindersSize++] = remainder;
                remainder = remainder % denominator * 10;
            }
        }
        System.out.println(result);
    }
}
