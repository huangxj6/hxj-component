package com.hxj.demo.rpc.test;

import java.util.Arrays;

public class 排序 {

	 public static void insertsort(int a[], int n){
		int i, j;
		for (i = 1; i < n; i++){
			for (j = i - 1; j >= 0 && a[j] > a[j + 1]; j--){
				
				int t = a[j];
				a[j] = a[j + 1];
				a[j + 1] = t;
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void main(String[] args) {
		insertsort(new int[] {33,324,11,43,23,8},6);
	}


}
