package kasu.budgetTracker.budgetTrackerDataStore.model;

public class DeleteByID {

    private int deleteById;

    public int getDeleteById() {
        return deleteById;
    }
    public void setDeleteById(int deleteById) {
        this.deleteById = deleteById;
    }

    @Override
    public String toString() {
        return "DeleteByID [deleteById=" + deleteById + "]";
    }

}
