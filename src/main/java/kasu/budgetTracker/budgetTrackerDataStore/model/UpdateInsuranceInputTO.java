package kasu.budgetTracker.budgetTrackerDataStore.model;

public class UpdateInsuranceInputTO extends NewInsuranceInputTO{

    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdateInsuranceInputTO [id=" + id + "]";
    }

}
