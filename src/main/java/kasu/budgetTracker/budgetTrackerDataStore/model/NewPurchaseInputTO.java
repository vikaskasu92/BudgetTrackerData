package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import kasu.budgetTracker.budgetTrackerDataStore.helper.BudgetTrackerDataHelper;

public class NewPurchaseInputTO extends UserTO{

    private String item;
    private BigDecimal cost;
    private String date;
    private LocalDate dateToDB;
	private String mainCategory;
    private String subCategory;

    public LocalDate getDateToDB() {
		return dateToDB;
	}
	public void setDateToDB(LocalDate dateToDB) {
		this.dateToDB = dateToDB;
	}
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getMainCategory() {
        return mainCategory;
    }
    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }
    public String getSubCategory() {
        return subCategory;
    }
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "NewPurchaseInputTO [item=" + item + ", cost=" + cost + ", date=" + date +
                ", mainCategory=" + mainCategory + ", subCategory=" + subCategory + "]";
    }

}
