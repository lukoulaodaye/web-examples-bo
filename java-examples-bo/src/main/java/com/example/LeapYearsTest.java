package com.example;

public class LeapYearsTest {
    public static void main(String[] args){
        test(1899,2046);
    }
    private static void test(int startYear,int endYear){
        int sum=0;
        for(int i=startYear;i<=endYear;i++){
            if(i%400==0||(i%4==0&&i%100!=0)){
                System.out.println(i);
                sum++;
            }

        } System.out.println(sum);
    }
}
