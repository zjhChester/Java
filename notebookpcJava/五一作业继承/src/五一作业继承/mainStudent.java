package ��һ��ҵ�̳�;

public class mainStudent {
		
		public static void main(String args[]){
	
		Student xiaobai = new Student(41700101,"С��",'Ů',19);
		Student xiaoxin = new Student(41700101,"С��",'��',20);
		
		System.out.println(xiaobai.getAge());
		System.out.println(xiaoxin.getAge());
		
		xiaobai.setAge(22);
		System.out.println(xiaobai.getAge());
	}

}
