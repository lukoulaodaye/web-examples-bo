package com.Test;

class Main {
    public class A {

        private String name;

        public A() {

            System.out.println("1");

        }

        public A(String name) {

            this.name = name;

            System.out.println("2");

        }

    }

    public class B extends A{

        private A a;

        public B() {

            System.out.println("3");

        }

        public B(String name) {

            System.out.println("4");

            a = new A("5");

        }

    }

}

public class MyClass {
    private int x;

    // 构造方法1
    public MyClass(int x) {
        this.x = x; // 使用this关键字指示实例变量x
    }

    // 构造方法2，调用构造方法1
    public MyClass() {
        this(0); // 调用另一个构造方法
    }

    // 返回当前对象的方法
    public MyClass getInstance() {
        return this;
    }

    // 方法接受当前对象的引用作为参数
    public void printInfo(MyClass obj) {
        System.out.println(this.x); // 访问实例变量
        System.out.println(  obj);
    }

    public static void main(String[] args) {
        MyClass obj1 = new MyClass(5);
        MyClass obj2 = new MyClass();

        obj1.printInfo(obj2); // 调用方法并传递对象引用
    }
}
