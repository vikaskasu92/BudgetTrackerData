package kasu.budgetTracker.budgetTrackerDataStore.model;

public class ClosedLoansTO {

    private String loanName;
    private String loanType;
    private double loanAPR;
    private double loanMonthlyAmount;
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

    @Override
    public String toString() {
        return "ClosedLoansTO [loanName=" + loanName + ", loanType=" + loanType + ", loanAPR=" + loanAPR
                + ", loanMonthlyAmount=" + loanMonthlyAmount + ", id=" + id + "]";
    }

}
