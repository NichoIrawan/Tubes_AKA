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
        }
        doctor.shift.add(this);
    }

    public void setShiftRecursive(int from, int to, Doctor doctor) {
        if (from < to) {
            shift[from] = doctor;
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

/*
public class Day {
    protected final String name;
    protected final int maxDoctorShift = 3;
    protected Doctor[][] shift = new Doctor[3][maxDoctorShift];
    protected int hourPerShift = 24/Shift.values().length;

    public Day(String name) {
        this.name = name;
    }

    public void setDoctorShift(Shift shift, Doctor doctor) {
        int i = -1;

        switch(shift) {
            case DAY:
                i = 0;
            case NOON:
                i = 1;
            case NIGHT:
                i = 2;
        }

        for(int j = 0; j < maxDoctorShift; j++) {
            if (this.shift[i][j] == null) {
                this.shift[i][j] = doctor;
                break;
            } else if (this.shift[i][j].getId() == doctor.getId()) {
                break;

        }
    }

    public void deleteDoctorShift(Doctor doctor) {
        for (int i = 0; i < Shift.values().length; i++) {
            for (int j = 0; j < maxDoctorShift; j++) {
                if (this.shift[i][j] != null && this.shift[i][j].getId() == doctor.getId()) {
                    this.shift[i][j] = null;
                }
            }
        }
    }

    public void getDoctor(Shift key) {
        switch (key) {
            case DAY:
                for (Doctor doctor : shift[0]) {
                    System.out.println(doctor);
                }
                break;
            case NOON:
                for (Doctor doctor : shift[1]) {
                    System.out.println(doctor);
                }
                break;
            case NIGHT:
                for (Doctor doctor : shift[2]) {
                    System.out.println(doctor);
                }
                break;
        }
    }
}*/