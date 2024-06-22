package com.experiment02.service;
import com.experiment02.entity.*;
import java.util.List;

public class OrderService {
    public static Order addOrder(User user, List<Item> items) {
        double totalCost = calculateTotalCost(items);
        if (user.getBalance() >= totalCost) {
            user.setBalance(user.getBalance() - totalCost);
            Order order = new Order(user, items, totalCost);
            return order;
        } else {
            System.out.println("用户余额不足，无法完成购买！");
            return null;
        }
    }

    private static double calculateTotalCost(List<Item> items) {
        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalCost;
    }
}