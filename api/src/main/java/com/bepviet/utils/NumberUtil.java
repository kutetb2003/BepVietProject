package com.bepviet.utils;

public class NumberUtil {
    public static boolean isNotNullAndPositive(Number number) {
        return number != null && number.doubleValue() > 0;
    }
}
