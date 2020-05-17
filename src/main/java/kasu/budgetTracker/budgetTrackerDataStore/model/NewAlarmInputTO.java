package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.math.BigDecimal;

public class NewAlarmInputTO extends UserTO{

    private String alarmBy;
    private BigDecimal budgetAmount;
    private String budgetEmail;

  
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
        return "NewAlarmInputTo [alarmBy=" + alarmBy + ", budgetAmount=" + budgetAmount + ", budgetEmail=" + budgetEmail
                + "]";
    }
}
