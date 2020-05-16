package kasu.budgetTracker.budgetTrackerDataStore.model;

public class CountTO {

    private int count;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "countTO [count=" + count + "]";
    }

}
