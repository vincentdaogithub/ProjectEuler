package com.vincentdao.project_euler;

public class Problem28 {

    private static final int MAX_SIZE = 1001;

    public static void main(String[] args) {
        long sum = 1;
        long startingNum = 1;
        for (int size = 3; size <= MAX_SIZE; size += 2) {
            for (int count = 0; count < 4; count++) {
                startingNum += size - 1;
                sum += startingNum;
            }
        }
        System.out.println(sum);
    }
}
