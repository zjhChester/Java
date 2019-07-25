package com.duotai;
class Animal{
	String name;
	int age;
	Animal(String name, int age){
		this.name = name;
		this.age = age;
	}
	void move(){
		System.out.println("我是动物我可以移动");
	}
	void breath(){
		System.out.println("我是动物我可以呼吸");
	}
}
	
class horse extends Animal{
	horse(String name,int age){
		super(name,age);
	}
	void move(){
		System.out.println("我是"+name+"我可以跑");
	}
}
class fish extends Animal{
	fish(String name,int age){
		super(name,age);
	}
	void move(){
		System.out.println("我是"+name+"我可以游");
	}
}
public class testAnimal {
	public static void main(String[] args) {
		
	
	Animal horse,fish;
	horse = new horse("马",1);
	fish = new fish("鱼",2);
	horse.move();
	horse.breath();
	fish.move();
	fish.breath();
	}
}