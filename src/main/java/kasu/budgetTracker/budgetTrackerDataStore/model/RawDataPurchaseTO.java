package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.time.LocalDate;

public class RawDataPurchaseTO {

    private String item;
    private String mainCategory;
    private String subCategory;
    private double cost;
    private LocalDate date;
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public String getMainCategory() {
        return mainCategory;
    }
    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }
    public String getSubCategory() {
        return subCategory;
    }
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RawDataPurchaseTO [item=" + item + ", mainCategory=" + mainCategory + ", subCategory=" + subCategory
                + ", cost=" + cost + ", date=" + date + ", id=" + id + "]";
    }
}
