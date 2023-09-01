package com.vincentdao.project_euler.common;

import java.util.Arrays;

public final class LargeInteger {

    private static final int MAX_SECTION_LENGTH = 10000000;
    private static final int INITIAL_SIZE = 100;

    private final long[] number;
    private final int maxSize;
    private final int size;

    private LargeInteger(long[] number, int size, int maxSize) {
        this.number = number;
        this.size = size;
        this.maxSize = maxSize;
    }

    public LargeInteger(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative integer");
        }
        if (number == 0) {
            long[] result = new long[INITIAL_SIZE];
            result[0] = 0;
            this.number = result;
            this.size = 1;
            this.maxSize = INITIAL_SIZE;
            return;
        }

        long tmpNum = number;
        this.number = new long[INITIAL_SIZE];
        int tmpSize = 0;
        for (int i = 0; tmpNum > 0; i++) {
            this.number[i] = tmpNum % MAX_SECTION_LENGTH;
            tmpNum /= MAX_SECTION_LENGTH;
            tmpSize++;
        }
        this.size = tmpSize;
        this.maxSize = INITIAL_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            builder.append(number[i]);
        }
        return builder.toString();
    }

    public LargeInteger add(LargeInteger anotherNumber) {
        int tmpMaxSize = Math.max(this.maxSize, anotherNumber.maxSize);
        int tmpSize = Math.min(this.size, anotherNumber.size);
        long[] result = new long[tmpMaxSize];
        long carryOver = 0;
        for (int i = 0; i < tmpSize; i++) {
            long sum = this.number[i] + anotherNumber.number[i] + (carryOver > 0 ? carryOver : 0);
            result[i] = sum % MAX_SECTION_LENGTH;
            carryOver = sum / MAX_SECTION_LENGTH;
        }
        if (this.size != anotherNumber.size) {
            boolean firstNumIsLarger = this.size > anotherNumber.size;
            int largerSize = firstNumIsLarger ? this.size : anotherNumber.size;
            for (int i = tmpSize; i < largerSize; i++) {
                long sum = firstNumIsLarger ? this.number[i] : anotherNumber.number[i];
                sum += carryOver > 0 ? carryOver : 0;
                result[i] = sum % MAX_SECTION_LENGTH;
                carryOver = sum / MAX_SECTION_LENGTH;
                tmpSize++;
            }
        }
        if (carryOver > 0) {
            if (tmpSize >= tmpMaxSize) {
                tmpMaxSize *= 2;
                result = Arrays.copyOf(result, tmpMaxSize);
            }
            result[tmpSize++] = carryOver;
        }
        return new LargeInteger(result, tmpSize, tmpMaxSize);
    }

    public int getDigitsCount() {
        int digitsCount = (size - 1) * 7;
        long lastSectionNum = number[size - 1];
        while (lastSectionNum > 0) {
            lastSectionNum /= 10;
            digitsCount++;
        }
        return digitsCount > 0 ? digitsCount : 1;
    }
}
