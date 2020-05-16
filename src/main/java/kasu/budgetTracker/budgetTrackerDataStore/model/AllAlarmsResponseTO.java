package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.math.BigDecimal;

public class AllAlarmsResponseTO {

    private String alarmBy;
    private BigDecimal budgetAmount;
    private String budgetEmail;
    private int id;
    private String user;
    private boolean alarmSent;

    public boolean isAlarmSent() {
        return alarmSent;
    }
    public void setAlarmSent(boolean alarmSent) {
        this.alarmSent = alarmSent;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAlarmBy() {
        return alarmBy;
    }
    public void setAlarmBy(String alarmBy) {
        this.alarmBy = alarmBy;
    }
    public BigDecimal getBudgetAmount() {
        return budgetAmount;
    }
    public void setBudgetAmount(BigDecimal budgetAmount) {
        this.budgetAmount = budgetAmount;
    }
    public String getBudgetEmail() {
        return budgetEmail;
    }
    public void setBudgetEmail(String budgetEmail) {
        this.budgetEmail = budgetEmail;
    }

    @Override
    public String toString() {
        return "AllAlarmsResponseTO [alarmBy=" + alarmBy + ", budgetAmount=" + budgetAmount + ", budgetEmail="
                + budgetEmail + ", id=" + id + ", user=" + user + ", alarmSent=" + alarmSent + "]";
    }

}
