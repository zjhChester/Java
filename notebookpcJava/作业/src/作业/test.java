package ��ҵ;

public class test{
	public static void main(String[] args) {
	
		bird b1 = new bird("��", 25, 12, 'M',2);
		
		b1.move();
		
		System.out.println("����:\t"+b1.getname());
		System.out.println("����:\t"+b1.getage());
		System.out.println("����:\t"+b1.getweight());
		System.out.println("�Ա�:\t"+b1.getsex());
	}
}