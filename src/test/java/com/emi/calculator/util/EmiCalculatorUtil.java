package com.emi.calculator.util;

public class EmiCalculatorUtil {
    final public static int WAIT_TIME = 30;

    public static void setWaitTime() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
