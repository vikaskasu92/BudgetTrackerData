package kasu.budgetTracker.budgetTrackerDataStore.model;

import org.springframework.stereotype.Component;

@Component
public class ExpenseByCategorySummaryInputTO extends  UserTO{

    private String category;
    private String subCategory;

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSubCategory() {
        return subCategory;
    }
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "ExpenseByCategorySummaryInputTO [ category=" + category + ", subCategory="
                + subCategory + "]";
    }

}
