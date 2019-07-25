package 五一作业继承;

public class mainStudent {
		
		public static void main(String args[]){
	
		Student xiaobai = new Student(41700101,"小白",'女',19);
		Student xiaoxin = new Student(41700101,"小鑫",'男',20);
		
		System.out.println(xiaobai.getAge());
		System.out.println(xiaoxin.getAge());
		
		xiaobai.setAge(22);
		System.out.println(xiaobai.getAge());
	}

}
