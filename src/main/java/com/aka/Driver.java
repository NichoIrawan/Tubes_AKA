package com.aka;

import java.util.ArrayList;

public class Driver {
    public Day[] days;
    public ArrayList<Doctor> doctors;

    public void initialize() {
//        days = new Day[500];
        days = new Day[7];
        doctors = new ArrayList<>();

        //Initialize days
        days[0] = new Day("Mon");
        days[1] = new Day("Tue");
        days[2] = new Day("Wed");
        days[3] = new Day("Thu");
        days[4] = new Day("Fri");
        days[5] = new Day("Sat");
        days[6] = new Day("Sun");

        //testing Purpose
//        for (int i = 7; i < days.length; i++) {
//            days[i] = new Day(Integer.toString(i));
//        }

        //Initialize doctors
        doctors.add(new Doctor(1, "Dr. A", 0, 8));
        doctors.add(new Doctor(2, "Dr. B", 0, 8));
        doctors.add(new Doctor(3, "Dr. C", 0, 8));
        doctors.add(new Doctor(4, "Dr. D", 8, 16));
        doctors.add(new Doctor(5, "Dr. E", 8, 16));
        doctors.add(new Doctor(6, "Dr. F", 8, 16));
        doctors.add(new Doctor(7, "Dr. G", 16, 23));
        doctors.add(new Doctor(8, "Dr. H", 16, 23));
        doctors.add(new Doctor(9, "Dr. I", 16, 23));
        doctors.add(new Doctor(10, "Dr. J", 0, 23));

        //testing purpose
//        for (int i = 11; i < 1000000; i++) {
//            doctors.add(new Doctor(i, "Dr. " + i, 0, 23));
//        }

//        doctors.add(new Doctor(11, "Dr. K", 0, 8 ));
//        doctors.add(new Doctor(12, "Dr. L", 0, 8));
//        doctors.add(new Doctor(13, "Dr. M", 8, 16));
//        doctors.add(new Doctor(14, "Dr. N", 8, 16));
//        doctors.add(new Doctor(15, "Dr. O", 16, 23));
//        doctors.add(new Doctor(16, "Dr. P", 16, 23));
//        doctors.add(new Doctor(17, "Dr. Q", 0, 8));
//        doctors.add(new Doctor(18, "Dr. R", 8, 16));
//        doctors.add(new Doctor(19, "Dr. S", 16, 23));
//        doctors.add(new Doctor(20, "Dr. T", 0, 23));


        //Doctor days unavailable
        // Doctor days unavailable
        doctors.getFirst().addDaysUnavailable(days[0]);
        doctors.getFirst().addDaysUnavailable(days[2]);
        doctors.getFirst().addDaysUnavailable(days[4]);

        doctors.get(1).addDaysUnavailable(days[1]);
        doctors.get(1).addDaysUnavailable(days[3]);
        doctors.get(1).addDaysUnavailable(days[5]);

        doctors.get(2).addDaysUnavailable(days[0]);
        doctors.get(2).addDaysUnavailable(days[3]);
        doctors.get(2).addDaysUnavailable(days[6]);

        doctors.get(3).addDaysUnavailable(days[1]);
        doctors.get(3).addDaysUnavailable(days[4]);
        doctors.get(3).addDaysUnavailable(days[6]);

        doctors.get(4).addDaysUnavailable(days[2]);
        doctors.get(4).addDaysUnavailable(days[5]);
        doctors.get(4).addDaysUnavailable(days[0]);

        doctors.get(5).addDaysUnavailable(days[3]);
        doctors.get(5).addDaysUnavailable(days[6]);
        doctors.get(5).addDaysUnavailable(days[1]);

        doctors.get(6).addDaysUnavailable(days[4]);
        doctors.get(6).addDaysUnavailable(days[0]);
        doctors.get(6).addDaysUnavailable(days[2]);

        doctors.get(7).addDaysUnavailable(days[5]);
        doctors.get(7).addDaysUnavailable(days[1]);
        doctors.get(7).addDaysUnavailable(days[3]);

        doctors.get(8).addDaysUnavailable(days[6]);
        doctors.get(8).addDaysUnavailable(days[2]);
        doctors.get(8).addDaysUnavailable(days[4]);

        doctors.get(9).addDaysUnavailable(days[0]);
        doctors.get(9).addDaysUnavailable(days[5]);
        doctors.get(9).addDaysUnavailable(days[6]);

//        doctors.get(10).addDaysUnavailable(days[1]);
//        doctors.get(10).addDaysUnavailable(days[3]);
//        doctors.get(10).addDaysUnavailable(days[4]);
//
//        doctors.get(11).addDaysUnavailable(days[2]);
//        doctors.get(11).addDaysUnavailable(days[0]);
//        doctors.get(11).addDaysUnavailable(days[3]);
//
//        doctors.get(12).addDaysUnavailable(days[3]);
//        doctors.get(12).addDaysUnavailable(days[1]);
//        doctors.get(12).addDaysUnavailable(days[5]);
//
//        doctors.get(13).addDaysUnavailable(days[4]);
//        doctors.get(13).addDaysUnavailable(days[2]);
//        doctors.get(13).addDaysUnavailable(days[0]);
//
//        doctors.get(14).addDaysUnavailable(days[5]);
//        doctors.get(14).addDaysUnavailable(days[3]);
//        doctors.get(14).addDaysUnavailable(days[1]);
//
//        doctors.get(15).addDaysUnavailable(days[6]);
//        doctors.get(15).addDaysUnavailable(days[4]);
//        doctors.get(15).addDaysUnavailable(days[2]);
//
//        doctors.get(16).addDaysUnavailable(days[0]);
//        doctors.get(16).addDaysUnavailable(days[2]);
//        doctors.get(16).addDaysUnavailable(days[4]);
//
//        doctors.get(17).addDaysUnavailable(days[2]);
//        doctors.get(17).addDaysUnavailable(days[3]);
//        doctors.get(17).addDaysUnavailable(days[5]);
//
//        doctors.get(18).addDaysUnavailable(days[4]);
//        doctors.get(18).addDaysUnavailable(days[6]);
//        doctors.get(18).addDaysUnavailable(days[0]);
//
//        doctors.get(19).addDaysUnavailable(days[5]);
//        doctors.get(19).addDaysUnavailable(days[1]);
//        doctors.get(19).addDaysUnavailable(days[3]);

    }

    //Time complexity pasti n => jml dokter
    public ArrayList<Doctor> groupingDoctors(Day day, int start, int end) {
        ArrayList<Doctor> doctors = new ArrayList<>();
        for (Doctor doctor : this.doctors) {
            if (!(doctor.daysUnavailable.contains(day)) && doctor.workHourStart <= start && doctor.workHourEnd >= end - 1 ) {
                doctors.add(doctor);
            }
        }
        return doctors;
    }

    //Time complexity pasti n => jml dokter
    public int max(ArrayList<Doctor> doctors) {
        int max = -1;

        for (Doctor doctor : doctors) {
            if (doctor.weeklyWorkHour > max) {
                max = doctor.weeklyWorkHour;
            }
        }
        return max;
    }

    //Time complexity pasti n => jml dokter
    public void resetWeeklyWorkHour() {
        for (Doctor doctor : doctors) {
            doctor.weeklyWorkHour = doctor.maxWorkHour;
        }
    }

    //Time complexity n => worst, best, average
    public Doctor searchAvailableDoctorIterative (Day day, int start, int end) {
        ArrayList<Doctor> doctors = groupingDoctors(day, start, end);
        int max = max(doctors);
        for (Doctor doctor : doctors) {
            if (doctor.weeklyWorkHour == max) {
                return doctor;
            }
        }
        return null;
    }

    //Time complexity n => worst, best, average
    public Doctor searchAvailableDoctorRecursive (Day day, ArrayList<Doctor> doctors, int doctorIndex, int start, int end, int maxWeeklyWorkHour) {
        if (doctorIndex == doctors.size()) {
            return null;
        } else {
            if (doctors.get(doctorIndex).weeklyWorkHour == maxWeeklyWorkHour) {
                return doctors.get(doctorIndex);
            }
            return searchAvailableDoctorRecursive(day, doctors, doctorIndex + 1, start, end, maxWeeklyWorkHour);
        }
    }

    //Time complexity pasti n^3 => 3 x for-loop
    public void setShiftIterative () {
        int workhour = 24 / Shift.values().length;

        for (Day day : days) {
            for (int i = 0; i < 24; i+=workhour) {
                int end = i + workhour;
                Doctor doctor = searchAvailableDoctorIterative(day, i, end);
                if (doctor != null) {
                    day.setShiftIterative(i, i + workhour, doctor);
                }
            }
        }
    }

    //Time complexity pasti n^3 => day++, workhour++, grouping & search
    public void setShiftRecursive (int dayIndex, int start, int end) {
        int workHour = 24 / Shift.values().length;

        if (dayIndex == days.length) {
            return;
        } else {
            if (start == 24) {
                setShiftRecursive(dayIndex + 1, 0, workHour);
            } else {
                ArrayList<Doctor> doctors =  groupingDoctors(days[dayIndex], start, end);
                int max = max(doctors);

                Doctor doctor = searchAvailableDoctorRecursive(days[dayIndex], doctors, 0, start, end - 1, max);
                if (doctor != null) {
                    days[dayIndex].setShiftRecursive(start, end, doctor);
                }
                setShiftRecursive(dayIndex, start + workHour, end + 24/Shift.values().length);
            }
        }
    }

    //Time complexity pasti n
    public void printDays() {
        for (Day day : days) {
            System.out.println(day);
        }
    }
}
