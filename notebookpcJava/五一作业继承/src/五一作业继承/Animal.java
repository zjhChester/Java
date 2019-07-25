package 五一作业继承;

public class Animal {
	String name;
	int age;
	String sex;
	Animal(String name, int age, String sex){
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	void enjoy()
	{
		System.out.println("I am so happy！");
	}

}

class dog extends Animal{
	String furcolor;
	dog(String name, int age, String sex,String furcolor){
		super(name,age,sex);
		this.furcolor = furcolor;
	}
	void enjoy()
	{
		System.out.println("I am so happy! wangwangwang!");
	}
}
class cat extends Animal
{
	String eyecolor;
	cat(String name, int age, String sex,String eyecolor)
	{
		super(name,age,sex);
		this.eyecolor = eyecolor;
	}
	void enjoy()
	{
		System.out.println("I am so happy! miaomiaomiao!");
	}
}

