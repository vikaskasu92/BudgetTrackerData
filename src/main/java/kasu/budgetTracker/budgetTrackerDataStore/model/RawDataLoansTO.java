package kasu.budgetTracker.budgetTrackerDataStore.model;

public class RawDataLoansTO {

    private String loanName;
    private String loanType;
    private double loanBalance;
    private double loanAPR;
    private double loanEMI;
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
    public double getLoanEMI() {
        return loanEMI;
    }
    public void setLoanEMI(double loanEMI) {
        this.loanEMI = loanEMI;
    }

    @Override
    public String toString() {
        return "RawDataLoansTO [loanName=" + loanName + ", loanType=" + loanType + ", loanBalance=" + loanBalance
                + ", loanAPR=" + loanAPR + ", loanEMI=" + loanEMI + ", id=" + id
                + "]";
    }

}
