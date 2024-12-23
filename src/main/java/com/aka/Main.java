package com.aka;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver();

        driver.initialize();
        driver.setShiftIterative();
        driver.printDays();
        System.out.println();

        driver.doctors.get(3).addDaysUnavailable(driver.days[0]);
        driver.setShiftIterative();
        driver.printDays();
    }
}