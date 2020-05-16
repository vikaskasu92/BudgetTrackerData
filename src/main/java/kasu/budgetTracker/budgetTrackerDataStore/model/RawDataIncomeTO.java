package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.time.LocalDate;

public class RawDataIncomeTO {

    private double salaryRecieved;
    private LocalDate dateRecieved;
    private double federalTax;
    private double stateTax;
    private double medicareTax;
    private double socialSecurityTax;
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getSalaryRecieved() {
        return salaryRecieved;
    }
    public void setSalaryRecieved(double salaryRecieved) {
        this.salaryRecieved = salaryRecieved;
    }
    public LocalDate getDateRecieved() {
        return dateRecieved;
    }
    public void setDateRecieved(LocalDate dateRecieved) {
        this.dateRecieved = dateRecieved;
    }
    public double getFederalTax() {
        return federalTax;
    }
    public void setFederalTax(double federalTax) {
        this.federalTax = federalTax;
    }
    public double getStateTax() {
        return stateTax;
    }
    public void setStateTax(double stateTax) {
        this.stateTax = stateTax;
    }
    public double getMedicareTax() {
        return medicareTax;
    }
    public void setMedicareTax(double medicareTax) {
        this.medicareTax = medicareTax;
    }
    public double getSocialSecurityTax() {
        return socialSecurityTax;
    }
    public void setSocialSecurityTax(double socialSecurityTax) {
        this.socialSecurityTax = socialSecurityTax;
    }

    @Override
    public String toString() {
        return "RawDataIncomeTO [salaryRecieved=" + salaryRecieved + ", dateRecieved=" + dateRecieved + ", federalTax="
                + federalTax + ", stateTax=" + stateTax + ", medicareTax=" + medicareTax + ", socialSecurityTax="
                + socialSecurityTax + ", id=" + id + "]";
    }

}

