package com.experiment02.entity;
import java.util.List;
public class Order {
    private User user;
    private List<Item> items;
    private double totalCost;

    public Order(User user, List<Item> items, double totalCost) {
        this.user = user;
        this.items = items;
        this.totalCost = totalCost;
    }

    // Getter methods
    public User getUser() {
        return user;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
