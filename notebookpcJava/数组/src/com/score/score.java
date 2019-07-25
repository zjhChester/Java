package com.score;

public class score {

	public static void main(String[] args) {
		
		int a[] = {95,99,66,89,97};
		int i,m = 0;
		int max=0;
		
		for(i=0;i<a.length;i++)
		{
			if(max<a[i])
			{
				max=a[i];
				m = i+1;
			}
		}
		System.out.println("the max = \t"+max+"\tat\ta["+m+"]");
	}
}
