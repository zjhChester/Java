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
		System.out.println("���ڿ���������\n�ѿ���...��ӭʹ��");
	}
	void Close(){
		System.out.println("���ڹػ�������\n�ѹػ�...ллʹ��");
	}
	void Sleep(){
		System.out.println("�������ߡ�����\nZZzzzzzz~");
	}
}
public class testcomputer {
	public static void main(String[] args) {
		computer c = new computer("����","�ƹ��","i7-8770k",16,"1T��̬Ӳ��*3",5700,"����");
		c.Open();
		c.Close();
	}
	
	
}
