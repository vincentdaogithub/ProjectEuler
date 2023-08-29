package com.vincentdao.project_euler;

import java.util.ArrayList;
import java.util.List;

public class Problem16 {

    private static final int MAX_POWER = 1000;

    public static void main(String[] args) {
        List<Integer> digits = new ArrayList<>(400);
        digits.add(2);
        for (int power = 2; power <= MAX_POWER; power++) {
            boolean hasCarryOver = false;
            for (int index = 0; index < digits.size(); index++) {
                int digit = digits.get(index) * 2 + (hasCarryOver ? 1 : 0);
                if (digit >= 10) {
                    hasCarryOver = true;
                    digits.set(index, digit % 10);
                } else {
                    hasCarryOver = false;
                    digits.set(index, digit);
                }
            }
            if (hasCarryOver) {
                digits.add(1);
            }
        }
        System.out.println(digits.stream().reduce(0, Integer::sum));
    }
}
