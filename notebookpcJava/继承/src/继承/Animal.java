package �̳�;

public class Animal {
	String name;
	int age;
	
	String furcolor;
	public Animal(String name,int age,String furcolor){
		this.name = name;
		this.age = age;
		this.furcolor = furcolor;
	}
	void move(){
		System.out.println("�����ǿ��Զ���.");
	}
}
class mice extends Animal{
	int weight;
	mice(int weight, String name,int age,String furcolor){
		super(name, age, furcolor);
		this.weight = weight;
	}
	void move(){
		System.out.println("�����ǿ����ܵ�");
		
	}
	public void shut()
	{
		
		System.out.println("����ҽУ�");
	}
}
class dog extends Animal{
	int weight;
	
	dog(int weight, String name,int age,String furcolor){
		super(name, age, furcolor);
		this.weight = weight;
	}
	static void Catchmice(int age,mice miceName){
		if(age >= 3 ) {
		
			miceName.shut();
			System.out.println("ץס��"+miceName.name+"��ֻ����");
		}
		else System.out.println("�����ܵ�");
	}
}
