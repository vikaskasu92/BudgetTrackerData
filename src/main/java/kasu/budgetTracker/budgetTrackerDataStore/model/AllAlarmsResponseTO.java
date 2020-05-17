package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.time.LocalDate;

public class AllAlarmsResponseTO {

	private float budgetAmount;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String budgetEmail;
    private String alarmBy;
    private String message;
    private String subject;
    private int id;
    private String user;
    private boolean alarmSent;

    
    public float getBudgetAmount() {
		return budgetAmount;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setBudgetAmount(float budgetAmount) {
		this.budgetAmount = budgetAmount;
	}
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
