package com.example.Junit_Mockito.coreJava;

public class FibonacciSeries {
    public static void main(String[] args) {
        int number=10;
        int firstTerm=0;
        int secondTerm=1;
        int nextTerm;
        for(int i=1;i<=number;++i){
            System.out.println(firstTerm + ",");
            nextTerm=firstTerm+secondTerm;
            firstTerm=secondTerm;
            secondTerm=nextTerm;
        }
    }
}
