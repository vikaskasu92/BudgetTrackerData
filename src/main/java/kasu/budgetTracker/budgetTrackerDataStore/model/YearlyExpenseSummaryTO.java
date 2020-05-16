package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.time.LocalDate;
import java.util.List;

public class YearlyExpenseSummaryTO {

    private LocalDate startYear;
    private LocalDate endYear;
    private List<YearlyExpenseSummaryRowMapperTO> yearlyExpenseSummary;

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
    public List<YearlyExpenseSummaryRowMapperTO> getYearlyExpenseSummary() {
        return yearlyExpenseSummary;
    }
    public void setYearlyExpenseSummary(List<YearlyExpenseSummaryRowMapperTO> yearlyExpenseSummary) {
        this.yearlyExpenseSummary = yearlyExpenseSummary;
    }

    @Override
    public String toString() {
        return "YearlyExpenseSummaryTO [startYear=" + startYear + ", endYear=" + endYear + ", yearlyExpenseSummary="
                + yearlyExpenseSummary + "]";
    }

}
