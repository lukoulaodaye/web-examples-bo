package com.experiment01;
import java.util.Scanner;

public class SummationTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个整数: ");// 数字
        double n = scanner.nextInt();
        System.out.println("请输入次数： ");// 循环次数
        int repeat = scanner.nextInt();
        double current = 0;
        double result = 0;
        for (int i = 0; i < repeat; i++) {
            current = current + n * Math.pow(10, i);
            result += current;
        }
        System.out.println(result);
    }
}
