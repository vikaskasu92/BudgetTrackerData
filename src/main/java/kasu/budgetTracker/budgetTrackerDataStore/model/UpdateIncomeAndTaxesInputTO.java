package kasu.budgetTracker.budgetTrackerDataStore.model;

public class UpdateIncomeAndTaxesInputTO extends NewIncomeAndTaxesInputTO {

    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdateIncomeAndTaxesInputTO [id=" + id + "]";
    }

}
