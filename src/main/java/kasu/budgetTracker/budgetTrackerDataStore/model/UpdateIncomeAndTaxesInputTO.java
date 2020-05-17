package kasu.budgetTracker.budgetTrackerDataStore.model;

public class UpdateIncomeAndTaxesInputTO extends NewIncomeAndTaxesInputTO {

	private int idToDB;
    private String id;
    
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
        return "UpdateIncomeAndTaxesInputTO [id=" + id + "]";
    }

}
