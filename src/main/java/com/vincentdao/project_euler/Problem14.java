package com.vincentdao.project_euler;

public class Problem14 {

    private static final int MAX_NUM = 1000000;

    public static void main(String[] args) {
        long largestCount = 1;
        long startingNumber = 3;
        for (int num = 3; num < MAX_NUM; num++) {
            int count = 1;
            long tmpNum = num;
            while (tmpNum > 1) {
                tmpNum = (tmpNum % 2 == 0) ? (tmpNum / 2) : (3 * tmpNum + 1);
                count++;
            }
            if (count > largestCount) {
                largestCount = count;
                startingNumber = num;
            }
        }
        System.out.println(startingNumber);
    }
}
