package com.intface;


public class testInterface {
 public static void main(String args[]){
	 circle b = new circle("Բ");
	System.out.println("Բ�����Ϊ"+b.area(5, 0, 0));
	System.out.println("Բ���ܳ�Ϊ"+ b.length(5, 0, 0));
	
	Rectangle r = new Rectangle("����");
	System.out.println("���ε����Ϊ"+ r.area(5, 6, 7));
	System.out.println("���ε��ܳ�Ϊ"+ r.length(5, 6, 7));
	
	
	triangle t = new triangle("����ֱ��������");
	System.out.println("�����ε����Ϊ"+ t.area(5, 5, 0));
	System.out.println("�����ε��ܳ�Ϊ"+ t.length(5, 5, 0));
	
 }
}
