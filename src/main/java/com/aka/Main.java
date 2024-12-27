package com.aka;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver();

        driver.initialize();

        long startTime = System.nanoTime();

        //Recursive
        System.out.println("===== RECURSIVE METHOD =====");
        driver.resetWeeklyWorkHour();
        driver.setShiftRecursive(0, 0, 24/Shift.values().length);
        driver.printDays();
        System.out.println();

        driver.doctors.get(3).addDaysUnavailable(driver.days[0]);
        driver.resetWeeklyWorkHour();
        driver.setShiftRecursive(0, 0, 24/Shift.values().length);
        driver.printDays();
        System.out.println();

        //Iterative
//        System.out.println("===== ITERATIVE METHOD =====");
//        driver.resetWeeklyWorkHour();
//        driver.setShiftIterative();
//        driver.printDays();
//        System.out.println();
//
//        driver.doctors.get(7).addDaysUnavailable(driver.days[2]);
//        driver.resetWeeklyWorkHour();
//        driver.setShiftIterative();
//        driver.printDays();
//        System.out.println();
//
//        //Data Dokter
//        System.out.println("===== Doctor Data =====");
//        for (Doctor doctor : driver.doctors) {
//            System.out.print(doctor);
//        }
//        System.out.println();

        long duration = (System.nanoTime() - startTime)/1000000;
        System.out.println("Total time: " + duration + " ms");
    }
}