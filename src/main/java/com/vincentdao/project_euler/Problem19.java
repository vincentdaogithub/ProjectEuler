package com.vincentdao.project_euler;

/**
 * DAYS = {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};
 */
public class Problem19 {

    private static final int START_YEAR = 1901;
    private static final int END_YEAR = 2000;

    public static void main(String[] args) {
        int currentDayIndex = 0;    // Monday
        int sundayCount = 0;
        for (int year = 1900; year <= END_YEAR; year++) {
            for (int month = 1; month <= 12; month++) {
                int remainingDays = 0;
                switch (month) {
                    case 2:
                        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                            remainingDays = 29 % 7;
                        }
                        break;

                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        remainingDays = 30 % 7;
                        break;

                    default:
                        remainingDays = 31 % 7;
                        break;
                }
                while (remainingDays > 0) {
                    currentDayIndex += 1;
                    if (currentDayIndex >= 7) {
                        currentDayIndex = 0;
                    }
                    remainingDays--;
                }
                if (year >= START_YEAR && (currentDayIndex + 1) >= 7) {
                    sundayCount++;
                }
            }
        }
        System.out.println(sundayCount);
    }
}
