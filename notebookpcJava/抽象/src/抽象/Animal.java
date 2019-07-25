package 抽象;

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
		System.out.println("喵喵");
	}
}
class dog extends Animal{
	dog(String name){
		super(name);

	}
	void makeSound(){
		System.out.println("汪汪");
	}
}
class test{
	public static void main(String[] args) {
		
	}
}
//如果再创建一个类没有makeSound 方法就会报错  因为父类为抽象类 子类必须跟随父类的抽象方法