package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NewInsuranceInputTO extends UserTO {

    private String insuranceType;
    private String insurancePaidDate;
    private LocalDate insurancePaidDateToDB;
    private BigDecimal insurnacePaidAmount;

    
    public LocalDate getInsurancePaidDateToDB() {
		return insurancePaidDateToDB;
	}
	public void setInsurancePaidDateToDB(LocalDate insurancePaidDateToDB) {
		this.insurancePaidDateToDB = insurancePaidDateToDB;
	}
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
    public String getInsurancePaidDate() {
        return insurancePaidDate;
    }
    public void setInsurancePaidDate(String insurancePaidDate) {
        this.insurancePaidDate = insurancePaidDate;
    }

    @Override
    public String toString() {
        return "NewInsuranceInputTO [insuranceType=" + insuranceType + ", insurancePaidDate=" + insurancePaidDate + "]";
    }

}
