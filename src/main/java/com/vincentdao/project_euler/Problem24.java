package com.vincentdao.project_euler;

public class Problem24 {

    private static final int PERMUTATION_NTH = 1000000;

    public static void main(String[] args) {
        int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int count = 2; count <= PERMUTATION_NTH; count++) {
            int largestK = -1;
            for (int k = 0; k + 1 < 10; k++) {
                if (num[k] < num[k + 1]) {
                    largestK = k;
                }
            }
            if (largestK == -1) {
                break;
            }
            int largestL = largestK + 1;
            for (int l = largestK + 1; l < 10; l++) {
                if (num[l] > num[largestK]) {
                    largestL = l;
                }
            }
            int swap = num[largestK];
            num[largestK] = num[largestL];
            num[largestL] = swap;
            for (int begin = largestK + 1, end = 9; begin < end; begin++, end--) {
                swap = num[begin];
                num[begin] = num[end];
                num[end] = swap;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(num[i]);
        }
        System.out.println();
    }
}
