package com.experiment01;


public class Student {
    private String name;
    private Gender gender; // 使用枚举类型

    // 构造函数接受name和Gender枚举类型的gender
    public Student(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    // getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // toString方法用于打印学生信息
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}