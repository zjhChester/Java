package com.arraytest;

public class yhsj

{

	public static void main(String[] args)

	{

//		System.out.println("请输入杨辉三角的行数");

//		Scanner in = new Scanner(System.in);

//		int a = in.nextInt();

		int a = 10;
		int arr[][] = new int[a][a + 2];

		for (int i = 1; i <= a; i++)

		{

			arr[i - 1][0] = 0;

			arr[i - 1][i + 1] = 0;

		}

		if (a == 1)

		{

			System.out.println(" 1 ");

		}

		if (a == 2)

		{

			System.out.println("   1 ");

			System.out.println(" 1 2 1");

		}

		else

		{

			arr[0][1] = 1;

			for (int j = 2; j <= a; j++)

			{

				for (int k = 1; k <= j; k++)

				{

					arr[j - 1][k] = arr[j - 2][k - 1] + arr[j - 2][k];

				}

			}

			for (int i = 1; i <= a; i++)

			{

				for (int space = 0; space <= a - i; space++)

				{

					System.out.print(" ");

				}

				for (int j = 1; j <= i; j++)

				{

					System.out.print(arr[i - 1][j] + " ");

				}

				System.out.println();

			}

		}

	}

}