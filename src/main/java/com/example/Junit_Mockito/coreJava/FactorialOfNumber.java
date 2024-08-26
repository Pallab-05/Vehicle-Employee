package com.example.Junit_Mockito.coreJava;

public class FactorialOfNumber {
    public static void main(String[] args) {
        int number=10;
        int factorial=1;
        for(int i=1;i<=number;++i){
            factorial=factorial*i;
        }
        System.out.println(factorial);
    }
}
