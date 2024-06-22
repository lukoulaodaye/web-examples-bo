package com.experiment01;

 enum Gender {
    MALE,
    FEMALE
}


public class Test {
    public static void main(String[] args) {
        // 创建男生学生
        Student maleStudent = new Student("张三", Gender.MALE);
        Student maleStudent1 = new Student("张三0", Gender.MALE);
        System.out.println(maleStudent); // 输出学生信息

        // 创建女生学生
        Student femaleStudent = new Student("李四", Gender.FEMALE);
        System.out.println(femaleStudent); // 输出学生信息
    }
}