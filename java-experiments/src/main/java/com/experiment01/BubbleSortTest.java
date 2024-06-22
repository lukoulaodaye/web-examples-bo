package com.experiment01;
import java.util.Scanner;


public class BubbleSortTest {

    public static void main(String[] args) {
        sort();
    }
    private static void sort() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度: ");
        int length = scanner.nextInt();
        int[] ints = new int[length];
        System.out.println("请输入" + length + "个整数:");
        for (int i = 0; i < length; i++) {
            ints[i] = scanner.nextInt();
        }
        for (int i = 0; i < ints.length - 1; i++) {

            for (int j = i + 1; j < ints.length; j++) {

                if (ints[i] > ints[j]) {
                    int temp = ints[j];
                    ints[j] = ints[i];
                    ints[i] = temp;
                }
            }
        }
        for (int i : ints) {
            System.out.println(i);
        }
    }
}

