package 作业;

public class test{
	public static void main(String[] args) {
	
		bird b1 = new bird("鸟", 25, 12, 'M',2);
		
		b1.move();
		
		System.out.println("姓名:\t"+b1.getname());
		System.out.println("年龄:\t"+b1.getage());
		System.out.println("体重:\t"+b1.getweight());
		System.out.println("性别:\t"+b1.getsex());
	}
}