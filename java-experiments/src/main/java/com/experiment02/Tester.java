package com.experiment02;

public class Tester {
   int var;
   Tester(double var) {
       this.var =(int)var;
   }
   Tester(int var) {
            this("hello");
        }
        Tester(String s) {
                this();
                System.out.println(s);
            }
            Tester(){
            System.out.println("Good-bye");
        }

    public static void main(String args[]) {
        Tester t= new Tester(5);
    }

}
