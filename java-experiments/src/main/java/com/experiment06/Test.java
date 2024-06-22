package com.experiment06;

import com.experiment06.entity.*;
import com.experiment06.logic.ShippingService;

public class Test {
    public static void main(String[] args) {
        Ship ship = new Ship("001", "CargoMaster", 105); // 创建货船
        Container[] containers = { // 创建集装箱
                new Container("C001", 30),
                new Container("C002", 50),
                new Container("C003", 40)
        };

        try {
            ship = ShippingService.loadContainers(ship, containers); // 装载集装箱
            System.out.println("启航！");
        } catch (OverweightException e) {
            System.out.println("装载失败：" + e.getMessage());
        } finally {
            System.out.println("无论是否超重，都打印启航的输出。");
        }
    }
}