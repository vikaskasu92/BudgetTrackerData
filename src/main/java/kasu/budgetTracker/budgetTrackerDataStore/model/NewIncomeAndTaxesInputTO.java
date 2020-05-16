package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NewIncomeAndTaxesInputTO extends UserTO {

    private BigDecimal salaryRecieved;
    private LocalDate dateRecieved;
    private BigDecimal federalTax;
    private BigDecimal stateTax;
    private BigDecimal medicareTax;
    private BigDecimal socialSecurityTax;

    public BigDecimal getSalaryRecieved() {
        return salaryRecieved;
    }
    public void setSalaryRecieved(BigDecimal salaryRecieved) {
        this.salaryRecieved = salaryRecieved;
    }
    public LocalDate getDateRecieved() {
        return dateRecieved;
    }
    public void setDateRecieved(LocalDate dateRecieved) {
        this.dateRecieved = dateRecieved;
    }
    public BigDecimal getFederalTax() {
        return federalTax;
    }
    public void setFederalTax(BigDecimal federalTax) {
        this.federalTax = federalTax;
    }
    public BigDecimal getStateTax() {
        return stateTax;
    }
    public void setStateTax(BigDecimal stateTax) {
        this.stateTax = stateTax;
    }
    public BigDecimal getMedicareTax() {
        return medicareTax;
    }
    public void setMedicareTax(BigDecimal medicareTax) {
        this.medicareTax = medicareTax;
    }
    public BigDecimal getSocialSecurityTax() {
        return socialSecurityTax;
    }
    public void setSocialSecurityTax(BigDecimal socialSecurityTax) {
        this.socialSecurityTax = socialSecurityTax;
    }

    @Override
    public String toString() {
        return "NewIncomeAndTaxesTO [salaryRecieved=" + salaryRecieved + ", dateRecieved=" + dateRecieved + ", federalTax="
                + federalTax + ", stateTax=" + stateTax + ", medicareTax=" + medicareTax + ", socialSecurityTax="
                + socialSecurityTax + "]";
    }


}
