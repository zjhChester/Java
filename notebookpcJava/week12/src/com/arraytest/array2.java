package com.arraytest;

public class array2 {
public static void main(String[] args) {
	int a[] = {1,2,3,4};
	int b[] = {5,6,7};
	int c[] = new int[7];
	for(int i=0;i<a.length;i++)
	{
		c[i]=a[i];
	}
	c[4] = b[0];
	c[5] = b[1];
	c[6] = b[2];
	for(int i=0;i<c.length;i++)
	{
		System.out.println(c[i]);
	}
}
}
