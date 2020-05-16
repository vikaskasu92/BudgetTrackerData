package kasu.budgetTracker.budgetTrackerDataStore.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RetrieveRawDataByInputAndDateTO extends UserTO {

    private String inputType;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int minPage;

    public int getMinPage() {
        return minPage;
    }
    public void setMinPage(int minPage) {
        this.minPage = minPage;
    }
    public String getInputType() {
        return inputType;
    }
    public void setInputType(String inputType) {
        this.inputType = inputType;
    }
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
        return "RetrieveRawDataByInputAndDateTO [inputType=" + inputType + ", fromDate=" + fromDate + ", toDate="
                + toDate + ", minPage=" + minPage + "]";
    }

}
