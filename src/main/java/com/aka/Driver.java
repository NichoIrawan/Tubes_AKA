package com.aka;

import java.util.ArrayList;

public class Driver {
    public Day[] days;
    public ArrayList<Doctor> doctors;

    public void initialize() {
        days = new Day[7];
        doctors = new ArrayList<>();

        //Initialize days
        days[0] = new Day("Monday");
        days[1] = new Day("Tuesday");
        days[2] = new Day("Wednesday");
        days[3] = new Day("Thursday");
        days[4] = new Day("Friday");
        days[5] = new Day("Saturday");
        days[6] = new Day("Sunday");

        //Initialize doctors
        doctors.add(new Doctor(1, "Dr. A", 0, 8, 40));
        doctors.add(new Doctor(2, "Dr. B", 0, 8, 40));
        doctors.add(new Doctor(3, "Dr. C", 0, 8, 40));
        doctors.add(new Doctor(4, "Dr. D", 8, 16, 40));
        doctors.add(new Doctor(5, "Dr. E", 8, 16, 40));
        doctors.add(new Doctor(6, "Dr. F", 8, 16, 40));
        doctors.add(new Doctor(7, "Dr. G", 16, 23, 40));
        doctors.add(new Doctor(8, "Dr. H", 16, 23, 40));
        doctors.add(new Doctor(9, "Dr. I", 16, 23, 40));
        doctors.add(new Doctor(10, "Dr. J", 0, 23, 40));

        //Doctor days unavailable
        doctors.getFirst().addDaysUnavailable(days[0]);
        doctors.get(1).addDaysUnavailable(days[0]);
        doctors.get(2).addDaysUnavailable(days[1]);
        doctors.get(3).addDaysUnavailable(days[1]);
        doctors.get(4).addDaysUnavailable(days[2]);
        doctors.get(5).addDaysUnavailable(days[2]);
        doctors.get(6).addDaysUnavailable(days[3]);
        doctors.get(7).addDaysUnavailable(days[4]);
        doctors.get(8).addDaysUnavailable(days[5]);
        doctors.get(9).addDaysUnavailable(days[6]);
    }

    public ArrayList<Doctor> groupingDoctors(Day day) {
        ArrayList<Doctor> doctors = new ArrayList<>();
        for (Doctor doctor : this.doctors) {
            if (!(doctor.daysUnavailable.contains(day))) {
                doctors.add(doctor);
            }
        }
        return doctors;
    }

    public int max(ArrayList<Doctor> doctors) {
        int max = -1;

        for (Doctor doctor : doctors) {
            if (doctor.weeklyWorkHour > max) {
                max = doctor.weeklyWorkHour;
            }
        }
        return max;
    }

    public Doctor searchAvailableDoctorIterative (Day day, int start, int end) {
        ArrayList<Doctor> doctors = groupingDoctors(day);
        int max = max(doctors);
        for (Doctor doctor : doctors) {
            if (!(doctor.daysUnavailable.contains(day)) && doctor.workHourStart <= start && doctor.workHourEnd >= end && doctor.weeklyWorkHour == max) {
                return doctor;
            }
        }
        return null;
    }

    public Doctor searchAvailableDoctorRecursive (Day day, int doctorIndex, int start, int end, int maxWeeklyWorkHour) {
        if (doctors.get(doctorIndex) == null) {
            return null;
        } else {
            if (!(doctors.get(doctorIndex).daysUnavailable.contains(day)) && doctors.get(doctorIndex).workHourStart <= start && doctors.get(doctorIndex).workHourEnd >= end && doctors.get(doctorIndex).weeklyWorkHour == maxWeeklyWorkHour) {
                return doctors.get(doctorIndex);
            }
            return searchAvailableDoctorRecursive(day, doctorIndex + 1, start, end, maxWeeklyWorkHour);
        }
    }

    public void setShiftIterative () {
        int workhour = 24 / Shift.values().length;

        for (Day day : days) {
            for (int i = 0; i < 24; i+= workhour) {
                Doctor doctor = searchAvailableDoctorIterative(day, i, i + workhour);
                if (doctor != null) {
                    day.setShiftIterative(i, i + workhour, doctor);
                }
            }
        }
    }

    public void setShiftRecursive () {}

    public void printDays() {
        for (Day day : days) {
            System.out.println(day);
        }
    }
}
