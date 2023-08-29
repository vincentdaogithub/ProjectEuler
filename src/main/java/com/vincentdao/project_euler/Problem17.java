package com.vincentdao.project_euler;

public class Problem17 {

    private static final int MAX = 1000;

    public static void main(String[] args) {
        long lettersCount = 0;
        for (int num = 1; num <= MAX; num++) {
            int[] numDigits = new int[4];
            for (int i = 3, tmpNum = num; tmpNum > 0 && i >= 0; i--, tmpNum /= 10) {
                numDigits[i] = tmpNum % 10;
            }
            if (numDigits[0] > 0) {
                lettersCount += digitToLettersCount(numDigits[0]) + 8;
            }
            if (numDigits[1] > 0) {
                lettersCount += digitToLettersCount(numDigits[1]) + 7;
            }
            if (numDigits[2] > 0) {
                if (numDigits[2] == 1) {
                    switch (numDigits[3]) {
                        case 0:
                            lettersCount += 3;
                            break;

                        case 1:
                        case 2:
                            lettersCount += 6;
                            break;

                        case 3:
                        case 4:
                        case 8:
                        case 9:
                            lettersCount += 8;
                            break;

                        case 5:
                        case 6:
                            lettersCount += 7;
                            break;

                        case 7:
                            lettersCount += 9;
                            break;

                        default:
                            throw new IllegalArgumentException();
                    }
                } else {
                    switch (numDigits[2]) {
                        case 2:
                        case 3:
                        case 8:
                        case 9:
                            lettersCount += 6;
                            break;

                        case 4:
                        case 5:
                        case 6:
                            lettersCount += 5;
                            break;

                        case 7:
                            lettersCount += 7;
                            break;

                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
            if (numDigits[3] > 0 && numDigits[2] != 1) {
                lettersCount += digitToLettersCount(numDigits[3]);
            }
            if ((numDigits[0] > 0 || numDigits[1] > 0) && (numDigits[2] > 0 || numDigits[3] > 0)) {
                lettersCount += 3;
            }
        }
        System.out.println(lettersCount);
    }

    private static int digitToLettersCount(int digit) {
        switch (digit) {
            case 1:
            case 2:
            case 6:
                return 3;

            case 3:
            case 7:
            case 8:
                return 5;

            case 4:
            case 5:
            case 9:
                return 4;

            default:
                throw new IllegalArgumentException();
        }
    }
}
