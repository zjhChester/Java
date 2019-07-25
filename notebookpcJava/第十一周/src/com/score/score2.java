package com.score;

public class score2 {
	public static void main(String[] args) {
		
	
	int [][]a = new int[4][4];
	a[0][0] = 1;
	a[1][0] = 1;
	a[2][0] = 1;
	a[3][0] = 1;
	a[1][1] = 2;
	a[2][1] = 2;
	a[3][1] = 2;
	a[2][2] = 3;
	a[3][2] = 3;
	a[3][3] = 4;
	int b[][] = {{1},{1,2},{1,2,3},{1,2,3,4}};
	for(int i=0;i<a.length;i++)
	{
		for(int j =0;j<=i;j++)
		{
			System.out.print(b[i][j]);
			//System.out.print(a[i][j]);
		}
		System.out.print("\n");
	}
	
	}
}
