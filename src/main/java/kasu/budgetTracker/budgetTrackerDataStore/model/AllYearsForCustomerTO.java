package kasu.budgetTracker.budgetTrackerDataStore.model;

public class AllYearsForCustomerTO {

    private String year;

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "AllYearsForCustomerTO [year=" + year + "]";
    }
}
