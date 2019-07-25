package com.arraytest;

import java.util.*;

public class inputarray {

	public static void main(String[] args) {
		int[] a = new int[10];
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int t = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = input.nextInt();
			sum += a[i];

		}
		int max = a[0], min = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[max] < a[i])
				max = i;
			if (a[min] > a[i])
				min = i;

		}
		System.out.println(a[max] + "\n" + a[min] + "\nmax at " + (max + 1) + "\nmin at " + (min + 1));
		System.out.println("avg = " + sum / a.length);
		System.out.println("ÅÅĞòÎª");
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}

			System.out.print("  " + a[i]);
		}
	}
}
