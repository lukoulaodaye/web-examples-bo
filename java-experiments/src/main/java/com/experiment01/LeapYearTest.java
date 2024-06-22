package com.experiment01;
import java.util.Scanner;
public class LeapYearTest {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个整数: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        test(num1,num2);
    }
    private static void test(int startYear,int endYear) {
        int sum = 0;
        for (int i = startYear; i <= endYear; i++) {
            if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                System.out.println(i);
                sum++;
            }
        }
        System.out.println("从"+startYear+"至"+endYear+"共有"+sum+"个闰年");
    }
}
