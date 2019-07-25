package com.suanfa;

public class test {


	public static void main(String[] args) {
	int [] a = new int [100];
	int [] b = new int [100];
	
	int sum=0;
	
	for (int i=0;i<a.length;i++)
	{
		a[i] = 1;
		b[i] = i+1;
		if(i%2==0)
		{
			sum += a[i]/b[i];
		}
		else
		{
			sum -= a[i]/b[i];
		}
	}
	System.out.println("\n最终结果为"+sum);
	
	}
}
