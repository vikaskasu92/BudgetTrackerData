package kasu.budgetTracker.budgetTrackerDataStore.model;

public class UpdateCustomerLoanInputTO extends NewLoanInputTO {

    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdateCustomerLoanInputTO [id=" + id + "]";
    }

}
