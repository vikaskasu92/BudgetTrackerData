package kasu.budgetTracker.budgetTrackerDataStore.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class YearlyExpenseSummaryInputTO extends UserTO {

    private LocalDate startYear;
    private LocalDate endYear;

    public LocalDate getStartYear() {
        return startYear;
    }
    public void setStartYear(LocalDate startYear) {
        this.startYear = startYear;
    }
    public LocalDate getEndYear() {
        return endYear;
    }
    public void setEndYear(LocalDate endYear) {
        this.endYear = endYear;
    }

    @Override
    public String toString() {
        return "YearlyExpenseSummaryInputTO{" +
                "startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}
