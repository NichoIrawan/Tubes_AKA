package com.aka;

import java.util.ArrayList;


public class Doctor {
    private final int id;
    private String name;
    protected int workHourStart;
    protected int workHourEnd;
    protected int weeklyWorkHour;
    protected ArrayList<Day> daysUnavailable;
    protected ArrayList<Day> shift;

    public Doctor(int id, String name, int workHourStart, int workHourEnd, int weeklyWorkHour) {
        this.id = id;
        this.name = name;
        this.workHourStart = workHourStart;
        this.workHourEnd = workHourEnd;
        this.weeklyWorkHour = weeklyWorkHour;
        this.daysUnavailable = new ArrayList<>();
        this.shift = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDaysUnavailable(Day dayUnavailable) {
        this.daysUnavailable.add(dayUnavailable);
    }

    public void removeDaysUnavailable(Day dayUnavailable) {
        this.daysUnavailable.remove(dayUnavailable);
    }

    @Override
    public String toString() {
        String s = String.format("[Nama] %s - [Shift] ", name);
        for (Day day : shift) {
            s = s + String.format("%s ", day.name);
        }
        return s + "\n";
    }
}