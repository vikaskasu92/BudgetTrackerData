package kasu.budgetTracker.budgetTrackerDataStore.model;

public class UpdatePurchaseInputTO extends NewPurchaseInputTO {

    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdatePurchaseInputTO{" +
                "id=" + id +
                '}';
    }
}
