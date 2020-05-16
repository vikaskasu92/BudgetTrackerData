package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.math.BigDecimal;

public class NewLoanInputTO extends UserTO {

    private String loanName;
    private String loanType;
    private BigDecimal loanBalance;
    private BigDecimal loanEMI;
    private double loanAPR;

    public String getLoanName() {
        return loanName;
    }
    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }
    public BigDecimal getLoanBalance() {
        return loanBalance;
    }
    public void setLoanBalance(BigDecimal loanBalance) {
        this.loanBalance = loanBalance;
    }
    public String getLoanType() {
        return loanType;
    }
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
    public BigDecimal getLoanEMI() {
        return loanEMI;
    }
    public void setLoanEMI(BigDecimal loanEMI) {
        this.loanEMI = loanEMI;
    }
    public double getLoanAPR() {
        return loanAPR;
    }
    public void setLoanAPR(double loanAPR) {
        this.loanAPR = loanAPR;
    }

    @Override
    public String toString() {
        return "NewLoanInputTO [loanName=" + loanName + ", loanType=" + loanType
                + ", loanBalance=" + loanBalance + ", loanEMI=" + loanEMI + ", loanAPR=" + loanAPR + "]";
    }

}
