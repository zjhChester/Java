package com.duotai;
class Animal{
	String name;
	int age;
	Animal(String name, int age){
		this.name = name;
		this.age = age;
	}
	void move(){
		System.out.println("���Ƕ����ҿ����ƶ�");
	}
	void breath(){
		System.out.println("���Ƕ����ҿ��Ժ���");
	}
}
	
class horse extends Animal{
	horse(String name,int age){
		super(name,age);
	}
	void move(){
		System.out.println("����"+name+"�ҿ�����");
	}
}
class fish extends Animal{
	fish(String name,int age){
		super(name,age);
	}
	void move(){
		System.out.println("����"+name+"�ҿ�����");
	}
}
public class testAnimal {
	public static void main(String[] args) {
		
	
	Animal horse,fish;
	horse = new horse("��",1);
	fish = new fish("��",2);
	horse.move();
	horse.breath();
	fish.move();
	fish.breath();
	}
}