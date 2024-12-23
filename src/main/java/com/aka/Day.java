package com.aka;

public class Day {
    protected final String name;
    protected Doctor[] shift;

    public Day(String name) {
        this.name = name;
        this.shift = new Doctor[24];
    }

    public void setShiftIterative(int from, int to, Doctor doctor) {
        for (int i = from; i < to; i++) {
            shift[i] = doctor;
            doctor.weeklyWorkHour--;
        }
        doctor.shift.add(this);
    }

    public void setShiftRecursive(int from, int to, Doctor doctor) {
        if (from < to) {
            shift[from] = doctor;
            doctor.weeklyWorkHour--;
            if (from + 1 == to) {
                doctor.shift.add(this);
            }
            setShiftRecursive(from + 1, to, doctor);
        }
    }

    public Doctor getDoctor(int key) {
        return shift[key];
    }
}
