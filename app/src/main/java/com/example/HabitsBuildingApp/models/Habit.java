package com.example.HabitsBuildingApp.models;

public class Habit {

    private String habitId;
    private String habit;
    private String reason;
    private String startDate;

    public Habit(String habitId, String habit, String reason, String startDate) {
        this.habitId = habitId;
        this.habit = habit;
        this.reason = reason;
        this.startDate = startDate;
    }

    public String getHabitId() {
        return habitId;
    }

    public void setHabitId(String habitId) {
        this.habitId = habitId;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
