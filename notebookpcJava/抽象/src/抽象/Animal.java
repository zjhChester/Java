package ����;

public abstract class Animal {
		private String name;
		abstract void makeSound();
		
		Animal(String name){
			this.name = name;
		}
		String getname(){
			return name;
		}
}
class cat extends Animal{
	cat(String name){
		super(name);

	}
	void makeSound(){
		System.out.println("����");
	}
}
class dog extends Animal{
	dog(String name){
		super(name);

	}
	void makeSound(){
		System.out.println("����");
	}
}
class test{
	public static void main(String[] args) {
		
	}
}
//����ٴ���һ����û��makeSound �����ͻᱨ��  ��Ϊ����Ϊ������ ���������游��ĳ��󷽷�