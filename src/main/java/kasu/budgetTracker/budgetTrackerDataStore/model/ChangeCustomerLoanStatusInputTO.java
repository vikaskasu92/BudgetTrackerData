package kasu.budgetTracker.budgetTrackerDataStore.model;

public class ChangeCustomerLoanStatusInputTO {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ChangeCustomerLoanStatusInputTO [id=" + id + "]";
    }
}
