package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.time.LocalDate;

public class RawDataInsuranceTO {

    private String insuranceType;
    private double insurnacePaidAmount;
    private LocalDate insurancePaidDate;
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getInsuranceType() {
        return insuranceType;
    }
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
    public double getInsurnacePaidAmount() {
        return insurnacePaidAmount;
    }
    public void setInsurnacePaidAmount(double insurnacePaidAmount) {
        this.insurnacePaidAmount = insurnacePaidAmount;
    }
    public LocalDate getInsurancePaidDate() {
        return insurancePaidDate;
    }
    public void setInsurancePaidDate(LocalDate insurancePaidDate) {
        this.insurancePaidDate = insurancePaidDate;
    }

    @Override
    public String toString() {
        return "RawDataInsuranceTO [insuranceType=" + insuranceType + ", insurnacePaidAmount=" + insurnacePaidAmount
                + ", insurancePaidDate=" + insurancePaidDate + ", id=" + id + "]";
    }


}
