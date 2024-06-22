package com.experiment03;
import com.experiment03.entity.*;
import com.experiment03.service.*;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        // 创建经理和销售人员
        Manager manager1 = new Manager("John", 5000, 2);
        Manager manager2 =new Manager("Bob",5000,3);
        Seller seller1 = new Seller("Alice", 3000, 20000, 0.15);
        Seller seller2 =new Seller("Mata",3500,28000,0.2);
        // 测试薪资计算方法和修改名字
        System.out.println("经理薪资：" + manager1.name+" " + manager1.calculateSalary());
        System.out.println("        "+ manager2.name+" " + manager2.calculateSalary());
        System.out.println("销售人员薪资：" + seller1.name+" "+ seller1.calculateSalary());
        System.out.println("           " + seller2.name+" "+ seller2.calculateSalary());
        manager1.updateName("Jack");
        seller1.updateName("Alen");
        System.out.println("经理薪资：" + manager1.name+" " + manager1.calculateSalary());
        System.out.println("销售人员薪资：" + seller1.name+" "+ seller1.calculateSalary());

        Employee[] employees = { manager1, seller1 , manager2, seller2 };
        // 统计员工薪资总额
        double totalSalaries = SalaryService.getTotalSalaries(employees);
        System.out.println("员工薪资总额：" + totalSalaries);
    }
}