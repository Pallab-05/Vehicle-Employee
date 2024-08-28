package com.example.Junit_Mockito.coreJava;

public class ArrayProgram {
    public static void main(String[] args) {
        System.out.println("calculating sum-------------");
        int arr[]={1,4,9,10};
        int sum=0;
        for(int i=0;i< arr.length;i++){
            sum=sum+arr[i];
        }
        System.out.println(sum);
        System.out.println("fetching the largest element from an array--------");
        int [] arr1={5,1,9,2,0};
        int max=0;
        for (int i=0;i< arr1.length;i++){
            if(max<arr1[i]){
                max=arr[i];
            }
        }
        System.out.println(max);
        System.out.println("Finding the index of the given element--------");
        int [] arr2={7,2,0,9,4,11,4};
        int given=4;
        int index=-1;
        for (int i=0;i< arr2.length;i++){
            if (arr2[i]==given){
                index=i;
                break;
            }
        }
        if(index==-1){
            System.out.println("Not found");
        }
        else {
            System.out.println("found index of " + given +" at index "+index);
        }
    }
}
