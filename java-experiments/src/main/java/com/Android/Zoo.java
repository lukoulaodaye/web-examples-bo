package com.Android;

interface Animal {
    void makeSound();
}

// Dog 类实现了 Animal 接口，表示狗
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Cat 类实现了 Animal 接口，表示猫
class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

public class Zoo {
    // performSound 方法接受一个动物对象，并让它发出声音
    public void performSound(Animal animal) {
        animal.makeSound();
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        // 使用具体类实例化对象
        Dog dog = new Dog();
        Cat cat = new Cat();

        // 让狗和猫发出声音
        zoo.performSound(dog);
        zoo.performSound(cat);

        // 使用匿名内部类实现接口，并实例化对象
        Animal bird = new Animal() {
            @Override
            public void makeSound() {
                System.out.println("Bird chirps");
            }
        };

        // 让鸟发出声音
        zoo.performSound(bird);
    }
}