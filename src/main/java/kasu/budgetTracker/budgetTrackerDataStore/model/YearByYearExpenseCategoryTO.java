package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.time.LocalDate;

public class YearByYearExpenseCategoryTO {

    private double price;
    private LocalDate date;
    private String subCategory;

    public String getSubCategory() {
        return subCategory;
    }
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "YearByYearExpenseCategoryTO [price=" + price + ", date=" + date + ", subCategory=" + subCategory + "]";
    }

}
