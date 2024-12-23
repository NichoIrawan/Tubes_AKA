package com.aka;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver();

        driver.initialize();

        //Recursive
        System.out.println("===== RECURSIVE METHOD =====");
        driver.setShiftRecursive(0, 0, 8);
        driver.printDays();
        System.out.println();

        driver.doctors.get(3).addDaysUnavailable(driver.days[0]);
        driver.setShiftRecursive(0, 0, 8);
        driver.printDays();
        System.out.println();

        //Iterative
        System.out.println("===== ITERATIVE METHOD =====");
        driver.setShiftIterative();
        driver.printDays();
        System.out.println();

        driver.doctors.get(6).addDaysUnavailable(driver.days[1]);
        driver.setShiftIterative();
        driver.printDays();
        System.out.println();
    }
}