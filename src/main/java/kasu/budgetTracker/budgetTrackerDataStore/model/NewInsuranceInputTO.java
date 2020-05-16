package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NewInsuranceInputTO extends UserTO {

    private String insuranceType;
    private LocalDate insurancePaidDate;
    private BigDecimal insurnacePaidAmount;

    public BigDecimal getInsurnacePaidAmount() {
        return insurnacePaidAmount;
    }
    public void setInsurnacePaidAmount(BigDecimal insurnacePaidAmount) {
        this.insurnacePaidAmount = insurnacePaidAmount;
    }
    public String getInsuranceType() {
        return insuranceType;
    }
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
    public LocalDate getInsurancePaidDate() {
        return insurancePaidDate;
    }
    public void setInsurancePaidDate(LocalDate insurancePaidDate) {
        this.insurancePaidDate = insurancePaidDate;
    }

    @Override
    public String toString() {
        return "NewInsuranceInputTO [insuranceType=" + insuranceType + ", insurancePaidDate=" + insurancePaidDate + "]";
    }

}
