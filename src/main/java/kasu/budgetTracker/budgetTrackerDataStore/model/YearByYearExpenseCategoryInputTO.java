package kasu.budgetTracker.budgetTrackerDataStore.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class YearByYearExpenseCategoryInputTO extends UserTO{

    private LocalDate fromDate;
    private LocalDate toDate;
    private String category;

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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "YearByYearExpenseCategoryInputTO [ fromDate=" + fromDate + ", toDate="
                + toDate + ", category=" + category + "]";
    }

}
