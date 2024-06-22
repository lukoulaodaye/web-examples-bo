package com.Android;
interface Clickable {
    void onClick();
}


class View implements Clickable {
    @Override
    public void onClick() {
        System.out.println("View clicked");
    }
}

class Button extends View {
    private String name; // 按钮名称

    // 构造函数
    public Button(String name) {
        this.name = name;
    }


    @Override
    public void onClick() {
        System.out.println( name );
    }
}

public class Test {
    public static void main(String[] args) {

        Button buttonA = new Button("ButtonA");
        Button buttonB = new Button("ButtonB");

        buttonB.onClick();
        buttonA.onClick();
        buttonA.onClick();
        buttonA.onClick();
        buttonA.onClick();
        buttonA.onClick();

    }
}