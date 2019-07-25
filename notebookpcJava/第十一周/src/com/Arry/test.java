package com.Arry;

public class test{
	public static void main(String args[])
	{
		double bsum = 0,fsum=0;//beforesum,finalsum;
		double []a = new double[100];
		for(int i=0;i<a.length;i++)
		{
			a[i] = i+1;
			bsum = 1/a[i];
			if(i%2==0) {
				fsum+=bsum;
				
			}
			else{
				fsum-=bsum;
				
			}
			System.out.println(fsum);
		}
	}
}