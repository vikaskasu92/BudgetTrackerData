package kasu.budgetTracker.budgetTrackerDataStore.model;

public class ChangeCustomerLoanStatusInputTO {

    private String id;
    private int idToDB;

    public int getIdToDB() {
		return idToDB;
	}
	public void setIdToDB(int idToDB) {
		this.idToDB = idToDB;
	}
	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ChangeCustomerLoanStatusInputTO [id=" + id + "]";
    }
}
