package kasu.budgetTracker.budgetTrackerDataStore.model;

import java.time.LocalDate;

public class ExpenseByCategoryTO {

    private double price;
    private LocalDate date;

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
        return "ExpenseByCategoryTO [price=" + price + ", date=" + date + "]";
    }
}
