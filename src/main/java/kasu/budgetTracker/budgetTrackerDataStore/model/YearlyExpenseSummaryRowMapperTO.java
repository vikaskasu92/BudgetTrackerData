package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.sql.Date;
import java.time.LocalDate;

public class YearlyExpenseSummaryRowMapperTO {

    private Double yearlyExpenseSummaryPrice;
    private Date yearlyExpenseSummaryDate;


    public Date getYearlyExpenseSummaryDate() {
        return yearlyExpenseSummaryDate;
    }

    public void setYearlyExpenseSummaryDate(Date yearlyExpenseSummaryDate) {
        this.yearlyExpenseSummaryDate = yearlyExpenseSummaryDate;
    }

    public Double getYearlyExpenseSummaryPrice() {
        return yearlyExpenseSummaryPrice;
    }

    public void setYearlyExpenseSummaryPrice(Double yearlyExpenseSummaryPrice) {
        this.yearlyExpenseSummaryPrice = yearlyExpenseSummaryPrice;
    }

    @Override
    public String toString() {
        return "YearlyExpenseSummaryRowMapperTO [yearlyExpenseSummaryPrice=" + yearlyExpenseSummaryPrice
                + ", yearlyExpenseSummaryDate=" + yearlyExpenseSummaryDate + "]";
    }

}
