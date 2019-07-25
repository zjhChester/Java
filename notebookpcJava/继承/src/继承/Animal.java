package 继承;

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
		System.out.println("动物是可以动的.");
	}
}
class mice extends Animal{
	int weight;
	mice(int weight, String name,int age,String furcolor){
		super(name, age, furcolor);
		this.weight = weight;
	}
	void move(){
		System.out.println("老鼠是可以跑得");
		
	}
	public void shut()
	{
		
		System.out.println("老鼠惨叫！");
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
			System.out.println("抓住了"+miceName.name+"这只老鼠");
		}
		else System.out.println("老鼠跑掉");
	}
}
