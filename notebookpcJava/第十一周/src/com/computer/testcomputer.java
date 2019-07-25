package com.computer;
class computer{
	String Brand;
	String color;
	String CPU;
	int Memory;
	String harddisk;
	double price;
	String work;
	computer(String Brand,
	String color,
	String CPU,
	int Memory,
	String harddisk,
	double price,
	String work){
		this.Brand = Brand;
		this.color = color;
		this.CPU = CPU;
		this.Memory = Memory;
		this.harddisk = harddisk;
		this.price = price;
		this.work = work;
		
	}
	void Open(){
		System.out.println("正在开机···\n已开机...欢迎使用");
	}
	void Close(){
		System.out.println("正在关机···\n已关机...谢谢使用");
	}
	void Sleep(){
		System.out.println("正在休眠···\nZZzzzzzz~");
	}
}
public class testcomputer {
	public static void main(String[] args) {
		computer c = new computer("联想","哑光黑","i7-8770k",16,"1T固态硬盘*3",5700,"开机");
		c.Open();
		c.Close();
	}
	
	
}
