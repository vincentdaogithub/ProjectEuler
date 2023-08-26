package com.vincentdao.project_euler;

public class Problem2 {

    public static void main(String[] args) {
        long resultSum = 0;
        long prevNum = 1;
        long currentNum = 1;
        while (true) {
            long tmp = currentNum;
            currentNum += prevNum;
            prevNum = tmp;
            if (currentNum > 4000000) {
                break;
            }
            if (currentNum % 2 == 0) {
                resultSum += currentNum;
            }
        }
        System.out.println(resultSum);
    }
}
