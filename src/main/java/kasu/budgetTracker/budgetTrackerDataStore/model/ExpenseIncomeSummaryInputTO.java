package kasu.budgetTracker.budgetTrackerDataStore.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ExpenseIncomeSummaryInputTO  extends UserTO{

    private LocalDate fromDate;
    private LocalDate toDate;

    public LocalDate getFromDate() {
        return fromDate;
    }
    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }
    public LocalDate getToDate() {
        return toDate;
    }
    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "ExpenseIncomeSummaryInputTO [fromDate=" + fromDate + ", toDate=" + toDate
                + "]";
    }
}
