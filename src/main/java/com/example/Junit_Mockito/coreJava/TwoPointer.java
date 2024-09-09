package com.example.Junit_Mockito.coreJava;

import java.util.Arrays;

import static org.apache.commons.lang3.ArrayUtils.reverse;
import static org.apache.commons.lang3.ArrayUtils.swap;

public class TwoPointer {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,1,1,0,1};
        int n = arr.length;
        System.out.println(Arrays.toString(sortPointer(arr, n)));
        int[]arr1={1,2,3,4,5,6,7,8,1};
        int m=arr1.length;
        System.out.println("swap even odd " + Arrays.toString(swapEvenOdd(arr1,m)));
        int[]arr2={-10,-3,-2,1,4,5,6};
        int n2= arr2.length;
        int[] ans =new int[n2];
       System.out.println("Square of array " + Arrays.toString(squareOfArray(ans,n2)));
    }
    public static int[] squareOfArray(int[]arr2, int n2){

        int p1=0;
        int p2=n2-1;
        int k = 0;
        int[] ans =new int[n2];
        while(p1<p2){
            if(Math.abs(arr2[p1])>Math.abs(arr2[p2])){
                ans[k]=arr2[p1]*arr2[p1];
                k--;
                p1++;
            }
            else {
                ans[k] = arr2[p2]*arr2[p2];
                k--;
                p2--;
            }
        }
        return ans;
    }
    public static int[] swapEvenOdd(int[]arr1,int m){
        int p1=0;
        int p2=m-1;
        while (p1<=p2){
            if(arr1[p1]%2==1 && arr1[p2]%2==0){
                swap(arr1,p1,p2);
                p1++;
                p2--;
            }
            if(arr1[p1]%2==0){
                p1++;
            }
            if(arr1[p2]%2==1){
                p2--;
            }
        }
        return arr1;
    }

    public static int[] sortPointer(int[] arr, int n) {
        int p1 = 0;
        int p2 = n - 1;
        while (p1 <= p2) {
            if (arr[p1] == 1 && arr[p2] == 0) {
                swap(arr, p1, p2);
                p1++;
                p2--;
            }
            if (arr[p1] == 0) {
                p1++;
            }
            if (arr[p2] == 1) {
                p2--;
            }
        }
        return arr;
    }
}
