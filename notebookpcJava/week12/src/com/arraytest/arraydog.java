package com.arraytest;

class dog {
	String name;
	int age;

	dog(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println(name);
		System.out.println(age);
	}
}

public class arraydog {
	public static void main(String[] args) {
		dog[] d = new dog[3];
		d[0] = new dog("xiaohei", 1);
		d[1] = new dog("xiaobai", 2);
		d[2] = new dog("xiaohui", 3);
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
	}
}
