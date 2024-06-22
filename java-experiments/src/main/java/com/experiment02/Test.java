package com.experiment02;
import com.experiment02.entity.*;
import com.experiment02.service.*;
import java.util.ArrayList;
import java.util.List;
public class Test {
    public static void main(String[] args) {
        User user = new User("Jerker", 200, "No. 26, Hexing Road, Xiangfang District, Harbin City, Heilongjiang Province");

        // 模拟商品
        Product product1 = new Product("Laptop", 80);
        Product product2 = new Product("Phone", 60);

        // 创建购买项
        Item item1 = new Item(product1, 1);
        Item item2 = new Item(product2, 2);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        // 测试订单逻辑
        Order order = OrderService.addOrder(user, items);
        if (order != null) {
            System.out.println("订单创建成功！");
            System.out.println("商品总额: " + order.getTotalCost());
            System.out.println("用户余额: " + user.getBalance());
            System.out.println("快递地址: " + user.getAddress());
        } else {
            System.out.println("用户余额不足，订单创建失败！");
        }

    }
}