package com.experiment03.service;
import com.experiment03.entity.*;
public class SalaryService {
    public static double getTotalSalaries(Workable... employees) {
        double totalSalaries = 0;
        for (Workable employee : employees) {
            totalSalaries += employee.calculateSalary();
        }
        return totalSalaries;
    }
}