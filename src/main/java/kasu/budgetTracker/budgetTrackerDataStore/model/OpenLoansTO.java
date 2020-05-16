package kasu.budgetTracker.budgetTrackerDataStore.model;

public class OpenLoansTO {

    private String loanName;
    private String loanType;
    private double loanBalance;
    private double loanAPR;
    private double loanMonthlyAmount;
    private double loanCompletionDuration;
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLoanName() {
        return loanName;
    }
    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }
    public String getLoanType() {
        return loanType;
    }
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
    public double getLoanBalance() {
        return loanBalance;
    }
    public void setLoanBalance(double loanBalance) {
        this.loanBalance = loanBalance;
    }
    public double getLoanAPR() {
        return loanAPR;
    }
    public void setLoanAPR(double loanAPR) {
        this.loanAPR = loanAPR;
    }
    public double getLoanMonthlyAmount() {
        return loanMonthlyAmount;
    }
    public void setLoanMonthlyAmount(double loanMonthlyAmount) {
        this.loanMonthlyAmount = loanMonthlyAmount;
    }
    public double getLoanCompletionDuration() {
        return loanCompletionDuration;
    }
    public void setLoanCompletionDuration(double loanCompletionDuration) {
        this.loanCompletionDuration = loanCompletionDuration;
    }

    @Override
    public String toString() {
        return "OpenLoansTO [loanName=" + loanName + ", loanType=" + loanType + ", loanBalance=" + loanBalance
                + ", loanAPR=" + loanAPR + ", loanMonthlyAmount=" + loanMonthlyAmount + ", loanCompletionDuration="
                + loanCompletionDuration + ", id=" + id + "]";
    }

}
